import org.json.JSONObject;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

    public final class NewsExtraction {
        private static final String newsFolder;
        private static final String API_Url;
        private static final String API;
        private static final int totalArticle;
        private static final String[] keywords;

        static {
            newsFolder = "./News/";
            API_Url = "https://newsapi.org/v2/everything";
            API = "44127310fd984d1db3e2c0af88d4b934 ";
            totalArticle = 50;
            keywords = new String[]{"Canada", "Halifax", "hockey", "hurricane", "electricity", "house", "inflation"};
        }

        private String fetchNews(final String category) {
            try {
                final String queryCategory = category.replaceAll(" ", "%20");
                final String newsAPIURL = API_Url + "?q=" + queryCategory + "&language=en&pageSize=" + totalArticle;
                /*Citation
                “Class HttpRequest.Builder,” HttpRequest.builder (java SE 10 &amp; JDK 10 ). [Online].
                Available: https://docs.oracle.com/javase/10/docs/api/jdk/incubator/http/HttpRequest.Builder.html. [Accessed: 23-Nov-2022].
                */
                final HttpRequest httpRequest = HttpRequest
                        .newBuilder(URI.create(newsAPIURL))
                        .header("X-Api-Key", API)
                        .timeout(Duration.of(30, ChronoUnit.SECONDS))
                        .GET()
                        .build();
                /*Citation
                “Class HttpRequest,” Moved, 06-Oct-2022. [Online].
                Available: https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html. [Accessed: 23-Nov-2022].
                */
                final HttpClient httpClient = HttpClient.newBuilder().build();
                final HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                System.out.println(httpResponse.body());
                return httpResponse.body();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return null;
            }
        }

        private void prepStoreNews(final String category, final String newsJSON) {
            /*Citation
                JSONObject, 27-Dec-2020. [Online].
                Available: https://stleary.github.io/JSON-java/org/json/JSONObject.html. [Accessed: 23-Nov-2022].
                */
            JSONObject j = new JSONObject(newsJSON);
            String newsResult = j.get("articles").toString();

            try{
                FileWriter f = new FileWriter("News/" + category + ".txt");
                f.write(newsResult);
                f.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        public void extractNewsData() {
            for (String category : keywords) {
                System.out.println("Fetching and storing news for " + category);
                final String newsJSON = fetchNews(category);
                if (newsJSON != null) {
                    prepStoreNews(category, newsJSON);
                }
            }
        }
    }