import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class NewsTransformation {
    private static final String separatorReplace;
    private static final String separatorSplit;
    private static final String empty;
    private static final String newsFolder;
    private static final String db;
    private static final String collection;

    static {
        separatorReplace = "}@@@@@@@@@{";
        separatorSplit = "@@@@@@@@@";
        empty = "";
        newsFolder = "./News/";
        db = "BigMongoNews";
        collection = "News";
    }

    private File[] readFiles() {
        final File newsDataFolder = new File(newsFolder);
        return newsDataFolder.listFiles();
    }

    private String transformContent(final String articleContent) {
        String transformContent;
        final String emoji = "[^\\p{L}\\p{N}\\p{P}\\p{Z}]";
        final String imageUrl = "(\"urlToImage\":(\"http.*?\"|null|\"null\"|\"\"),)";
        final String url = "(\"url\":(\"http.*?\"|null|\"null\"|\"\"),)";
        final String author = "(\"author\":(\"http.*?\"|null|\"null\"|\"\"),)";
        final String id = "(,\"id\":(null|\"null\"|\"\"))";
        final String general = "(\\\\[ntr])|( )|(<[^>]*>)";
        final String separator = "},{";
        transformContent = articleContent.replaceAll(emoji, empty);
        transformContent = transformContent.replaceAll(imageUrl, empty);
        transformContent = transformContent.replaceAll(url, empty);
        transformContent = transformContent.replaceAll(author, empty);
        transformContent = transformContent.replaceAll(id, empty);
        transformContent = transformContent.replaceAll(general, empty);
        transformContent = transformContent.substring(1, transformContent.length() - 1);
        transformContent = transformContent.replace(separator, separatorReplace);
        return transformContent;
    }

    private void filterArticles(final File[] allNewsFiles, final List<Document> newsDoc) {
        int totalArticlesRead = 0;
        for (final File newsFile : allNewsFiles) {
            try {
                final String newsFileContent = Files.readString(Paths.get(newsFile.getPath())).trim();
                final String[] filteredArticlesList = transformContent(newsFileContent).split(separatorSplit);
                for (String article : filteredArticlesList) {
                    final Document articleDoc = Document.parse(article);
                    newsDoc.add(articleDoc);
                    totalArticlesRead++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        System.out.println("New filtered articles are " + totalArticlesRead);
    }
    public void filterNews() {
        final File[] allNewsFiles = readFiles();
        if (allNewsFiles != null && allNewsFiles.length != 0) {
            final List<Document> newsDoc = new ArrayList<>();
            System.out.println("Filtering all articles...");
            filterArticles(allNewsFiles, newsDoc);
            /*Citation
            “Using mongodb with java,” MongoDB. [Online].
            Available: https://www.mongodb.com/languages/java. [Accessed: 23-Nov-2022].
             */
            try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                final MongoCollection<Document> mongoNewsCollection = mongoClient.getDatabase(db).getCollection(collection);
                mongoNewsCollection.insertMany(newsDoc);
                System.out.println("Filtered articles stored.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}