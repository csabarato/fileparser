package main.java.fileparser;

import java.util.List;
import java.util.Map;

/**
 * Utility class to analyze the words in a given map.
 *
 * Methods:
 * - calculate the total word count
 * - get the 5 most frequent words
 * - count the unique words in the map
 */
public class WordsAnalyzerUtil {

    private WordsAnalyzerUtil() {
        throw new UnsupportedOperationException("Utility class, can't be instantiated");
    }

    public static int calculateTotalWordCount(Map<String, Integer> wordMap) {
        int totalWordCount = 0;
        for (int v : wordMap.values()) {
            totalWordCount += v;
        }
        return totalWordCount;
    }

    public static List<String> getMostFrequentWords(Map<String, Integer> wordMap) {

        List<String> wordsSorted = wordMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList()
                .reversed();

        return wordsSorted.stream().limit(5).toList();
    }
    public static long calculateUniqueWordsCount(Map<String, Integer> wordMap) {
        return wordMap.values()
                .stream()
                .filter(v -> v == 1)
                .count();
    }
}
