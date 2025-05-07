package practice;

import java.util.HashMap;
import java.util.Map;

public class SymbolCount {
    public static void main(String[] args) {

        String input = "hello world!";

        Map<Character, Integer> symbolCountMap = new HashMap<>();
        for (char symbol : input.toCharArray()) {
            symbolCountMap.put(symbol, symbolCountMap.getOrDefault(symbol, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : symbolCountMap.entrySet()) {
            System.out.println("Սիմվոլ " + entry.getKey() + " է հանդիպել" + entry.getValue() + " անգամ(ներ)");
        }
    }
}