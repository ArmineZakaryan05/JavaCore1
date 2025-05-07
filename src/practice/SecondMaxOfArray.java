package practice;

public class SecondMaxOfArray {
    public static int findSecondMax(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            throw new RuntimeException("No second maximum found (all elements may be equal).");
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 5, 20, 8};
        int secondMax = findSecondMax(numbers);
        System.out.println("Second max value: " + secondMax);
    }
}
