package practice;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumbers {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 1, 5, 3, 1, 6, 7, 8, 7};

        Map<Integer, Integer> numberCountMap = new HashMap<>();

        for (int num : array) {
            numberCountMap.put(num, numberCountMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("Duplicate numbers and their counts:");
        for (Map.Entry<Integer, Integer> entry : numberCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
