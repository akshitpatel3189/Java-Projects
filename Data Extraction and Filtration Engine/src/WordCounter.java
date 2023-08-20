import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WordCounter {
    private static final String newsFolder;
    private static final String[] keywords;

    static {
        newsFolder = "./News/";
        keywords = new String[]{"Canada", "Halifax", "hockey", "hurricane", "electricity", "house", "inflation"};
    }

    private Map<String, Integer> initWordCounterMap() {
        final Map<String, Integer> wordCounterMap = new HashMap<>();
        final Integer initialWordCount = 0;
        for (String categoryKeyword : keywords) {
            wordCounterMap.put(categoryKeyword, initialWordCount);
        }
        return wordCounterMap;
    }

    private File[] readFile() {
        final File newsFile = new File(newsFolder);
        return newsFile.listFiles();
    }

    private String map(final String newsContent) {
        final Matcher titleMatcher = Pattern.compile("(\"title\":\".*?\",)").matcher(newsContent);
        final Matcher contentMatcher = Pattern.compile("(\"content\":\".*?\"},*)").matcher(newsContent);
        final StringBuilder mappedStringBuilder = new StringBuilder();
        while (titleMatcher.find()) {
            mappedStringBuilder.append(titleMatcher.group());
        }
        while (contentMatcher.find()) {
            mappedStringBuilder.append(contentMatcher.group());
        }
        return mappedStringBuilder.toString();
    }

    private void reduce(final String mappedString, final Map<String, Integer> wordCounterMap) {
        for (String keyword : keywords) {
            int lastIndex = 0;
            while (lastIndex != -1) {
                lastIndex = mappedString.indexOf(keyword, lastIndex);
                if (lastIndex != -1) {
                    wordCounterMap.put(keyword, wordCounterMap.get(keyword) + 1);
                    lastIndex += keyword.length();
                }
            }
        }
    }

    private void performMapReduce(final File[] files, final Map<String, Integer> wordCounterMap) {
        for (final File newsFile : files) {
            try {
                final String fileContent = Files.readString(Paths.get(newsFile.getPath())).trim();
                final String mappedString = map(fileContent);
                reduce(mappedString, wordCounterMap);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    public Map<String, Integer> wordCountNewsData() {
        final Map<String, Integer> wordCounterMap = initWordCounterMap();
        final File[] files = readFile();
        if (wordCounterMap.isEmpty() || files != null && files.length != 0) {
            performMapReduce(files, wordCounterMap);
        }
        return wordCounterMap;
    }
}