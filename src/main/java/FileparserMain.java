package main.java;

import java.util.Map;

public class FileparserMain {
    public static void main(String[] args) {
        Map<String, Integer> wordsMap = FileReader.readFile("src/main/resources/file1.txt");
        System.out.println(wordsMap);
    }
}
