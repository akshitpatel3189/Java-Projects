import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main {
    public static void main(String[] args) {
        try {

            final NewsExtraction newsExtraction = new NewsExtraction();
            newsExtraction.extractNewsData();

            Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

            final NewsTransformation newsTransformation = new NewsTransformation();
            newsTransformation.filterNews();

            final WordCounter wordCounter = new WordCounter();
            final Map<String, Integer> wordCounterMap = wordCounter.wordCountNewsData();

            System.out.printf("%n%-15s%-10s%n", "Word", "Frequency");
            for (Map.Entry<String, Integer> wordFrequency : wordCounterMap.entrySet())
            {
                System.out.printf("%-15s%-10s%n", wordFrequency.getKey(), wordFrequency.getValue());
            }
            int maxWordCount = -1;
            String maxWord = null;
            int minWordCount = -1;
            String minWord = null;
            for (Map.Entry<String, Integer> wordFrequency : wordCounterMap.entrySet())
            {
                if (minWordCount == -1 && maxWordCount == -1)
                {
                    minWord = wordFrequency.getKey();
                    maxWord = wordFrequency.getKey();
                    minWordCount = wordFrequency.getValue();
                    maxWordCount = wordFrequency.getValue();
                }
                else
                {
                    if (wordFrequency.getValue() > maxWordCount)
                    {
                        maxWord = wordFrequency.getKey();
                        maxWordCount = wordFrequency.getValue();
                    }
                    if (wordFrequency.getValue() < minWordCount)
                    {
                        minWord = wordFrequency.getKey();
                        minWordCount = wordFrequency.getValue();
                    }
                }
            }
            System.out.println("\n \"" + maxWord + "\" have the highest frequency with \"" + maxWordCount + "\".");
            System.out.println(" \"" + minWord + "\" have the lowest frequency with \"" + minWordCount + "\".");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}