package main.java.fileparser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileReader {



    /**
     * Reads a file and counts the occurrences of each word in it.
     *
     * Each line is splitted into words, non-alphanumeric characters are removed from each word.
     * The words are stored in HashMap, the key is the word and the value is
     * the number of occurrences. The map is then returned.
     *
     * @param filePath the path to the file to read
     * @return a map of words to the number of times they appear in the file
     */
    public static Map<String, Integer> readFile(String filePath) {

        HashMap<String, Integer> wordsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath))){

            String line;
            while ((line = br.readLine()) != null) {
                Arrays.stream(line.split(" "))
                        .map(word -> word.replaceAll("[^A-Za-z0-9]", ""))
                        .filter(word -> !word.isEmpty())
                        .forEach(word -> {
                            wordsMap.computeIfPresent(word, (k, v) -> v + 1);
                            wordsMap.computeIfAbsent(word, k -> 1);
                        });
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
        }
        return wordsMap;
    }
}
