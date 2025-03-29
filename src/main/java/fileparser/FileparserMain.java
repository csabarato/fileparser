package main.java.fileparser;

import java.util.Map;
import java.util.Scanner;

public class FileparserMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();

        Map<String, Integer> wordsMap = FileReader.readFile(filePath);

        if (wordsMap.isEmpty()) {
            System.out.println("Words map is empty, interrupt file analysis.");
            return;
        }

        ReportGenerator reportGenerator = new ReportGenerator(wordsMap);
        reportGenerator.generateReport();
    }
}
