package homework;

public class ArrayUtil {

    public static void main(String[] args) {

        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        //ex.1
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        //ex.2
        System.out.println(numbers[0]);

        //ex.3
        int length = numbers.length;
        System.out.println(numbers[length - 1]);

        //ex.4
        System.out.println(numbers.length);

        //ex.5
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println(min);
        System.out.println();

        // ex.6
        if (numbers.length <= 2) {
            System.err.println("Can't print middle values");
        } else {
            if (numbers.length % 2 == 0) {
                System.out.print(numbers[(numbers.length / 2) - 1]);
            } else {
                System.out.print(numbers[(numbers.length / 2)]);
            }
        }
        System.out.println();

        //ex.7
        int oddCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                oddCount++;
            }
        }
        System.out.println(oddCount);

        //ex.8
        int evenCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                evenCount++;
            }
        }
        System.out.println(evenCount);

        //ex.9
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);

        //10
        System.out.println(sum / numbers.length);
    }
}
