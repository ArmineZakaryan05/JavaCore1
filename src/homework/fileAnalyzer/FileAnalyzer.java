package homework.fileAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        // Читаем файл, составляем мапу слово-количество и возвращаем ее
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    if (wordCountMap.containsKey(word)) {
                        wordCountMap.put(word, wordCountMap.get(word) + 1);
                    } else {
                        wordCountMap.put(word, 1);
                    }
                }
            }
        }
        return wordCountMap;
    }


    public int totalWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем общее количество слов
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }
        return wordCount;
    }


    public int uniqueWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем количество уникальных слов
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s");

                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    if (!word.isEmpty()) {
                        uniqueWords.add(word);
                    }
                }
            }
        }
        return uniqueWords.size();
    }


    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        // Читаем файл, находим топ-N часто встречающихся слов
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCountMap.entrySet());

        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        Map<String, Integer> topWordsMap = new LinkedHashMap<>();

        for (int i = 0; i < n && i < entryList.size(); i++) {
            topWordsMap.put(entryList.get(i).getKey(), entryList.get(i).getValue());
        }
        return topWordsMap;
    }


    public int countWordOccurrences(String path, String word) throws IOException {
        // Читаем файл, находим количество вхождений слова и возвращаем это число
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s");

                for (String s : words) {
                    s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    if (s.equals(word)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
