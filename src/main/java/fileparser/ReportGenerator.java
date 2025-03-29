package main.java.fileparser;


import java.util.Map;


/**
 * Report generator, generates report from a map of words.
 */
public class ReportGenerator {

    private final Map<String,Integer> wordMap;

    public ReportGenerator(Map<String, Integer> wordMap) {
        this.wordMap = wordMap;
    }

    /**
     * Generates a report from a map of words.
     * The report will contain:
     * - Total word count
     * - The top 5 most frequent words with their frequency and percentage
     * - The number of unique words.
     */
    public void generateReport() {
        StringBuilder sb = new StringBuilder();

        int totalWordCount = WordsAnalyzerUtil.calculateTotalWordCount(wordMap);
        sb.append("Total word count : ").append(totalWordCount).append("\n");

        sb.append("Top 5 most frequent words:\n");

        for (String word : WordsAnalyzerUtil.getMostFrequentWords(wordMap)) {
            double percentage = ((double) wordMap.get(word) / totalWordCount) * 100;
            sb.append(word).append(" - ").append(wordMap.get(word)).append(" (").append(String.format("%.2f", percentage)).append("%)\n");
        }

        sb.append("Number of unique words: ").append(WordsAnalyzerUtil.calculateUniqueWordsCount(wordMap));

        System.out.println(sb);
    }
}
