package practice;

public class BubbleSortExample {
    public static void bubbleSort(int[] array) {
        int n = array.length;
       boolean swapped;

        // Անցնում ենք ամբողջ զանգվածով
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Եթե տարրերը սխալ հերթականությամբ են՝ փոխենք
                if (array[j] > array[j + 1]) {
                    // Փոխանակում
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // Եթե այս փուլում ոչ մի փոխանակում չի եղել՝ զանգվածն արդեն սորտավորված է
            if (!swapped) {
                break;
            }
        }
   }

    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};
        bubbleSort(numbers);

        System.out.print("Sorted array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
