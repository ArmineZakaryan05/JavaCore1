package practice;

public class MaxOfArray {
    public static int findMax(int[] array) {
        int max = array[0]; // Սկսում ենք առաջին տարրից
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // Թարմացնում ենք max-ը, եթե գտնենք ավելի մեծ
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {12, 5, 9, 27, 3};
        int max = findMax(numbers);
        System.out.println("Max value in array: " + max);
    }
}
