package practice;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWords {
    public static void main(String[] args) {
        String input = "This is a test string with test words and this is a test";

        Map<String, Integer> wordCountMap = new HashMap<>();

        String[] words = input.toLowerCase().split("\\s+");

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Duplicate words:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
