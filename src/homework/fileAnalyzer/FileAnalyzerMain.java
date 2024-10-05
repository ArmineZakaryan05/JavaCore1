package homework.fileAnalyzer;

import java.io.IOException;
import java.util.Map;

public class FileAnalyzerMain {


    public static void main(String[] args) {
        String FILE_PATH = "C:\\Users\\User\\IdeaProjects\\JavaCore1\\src\\homework\\fileAnalyzer\\text";
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        String targetWord = "computer";
        int topN = 3;

        try {
            Map<String, Integer> wordCountMap = fileAnalyzer.wordMap(FILE_PATH);
            System.out.println("Word count Map: " + wordCountMap);

            int totalWords = fileAnalyzer.totalWordCount(FILE_PATH);
            System.out.println("Total word count: " + totalWords);

            int uniqueWords = fileAnalyzer.uniqueWordCount(FILE_PATH);
            System.out.println("Unique word count: " + uniqueWords);

            Map<String, Integer> topWords = fileAnalyzer.topFrequentWords(FILE_PATH, topN);
            System.out.println("Top " + topN + " frequent words: " + topWords);

            int occurrences = fileAnalyzer.countWordOccurrences(FILE_PATH, targetWord);
            System.out.println("Occurrences of '" + targetWord + "': " + occurrences);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}