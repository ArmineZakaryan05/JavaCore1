package homework;

public class ArrayHomework {

    public static void main(String[] args) {

        int[] numbers = {3, 5, 9, 6, 8, 6, 7, 1, 6, 2};
        //ex.1
        int n = 6;
        int count = 0;
        for (int num : numbers) {
            if (num == n) {
                count++;
            }
        }
        System.out.println("count: " + count);
        System.out.println();

        //ex.2
        //option1
//        System.out.println();
//        int[] reversedArray = new int[numbers.length];
//        int j = 0;
//        for (int i = numbers.length - 1; i >= 0; i--) {
//            reversedArray[j++] = numbers[i];
//        }
//        for (int x : reversedArray) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
//        System.out.println();
        //option2
        int startIndex = 0;
        int endIndex = numbers.length - 1;

        /*for (int i = 0; i < numbers.length / 2; i++) {
            int tmp = numbers[i];
            numbers[i] = numbers[endIndex];
            numbers[endIndex--] = tmp;
        }*/
        //option3
        while (startIndex < endIndex) {
            int tmp = numbers[startIndex];
            numbers[startIndex] = numbers[endIndex];
            numbers[endIndex] = tmp;
            startIndex++;
            endIndex--;
        }
        for (int x : numbers) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println();


        //ex.3
        int duplicateCount = 0;
        int[] duplicateNumbers = new int[numbers.length];
        int duplicateNumbersIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int a = i + 1; a < numbers.length; a++) {
                if (numbers[i] == numbers[a]) {
                    boolean existDuplicate = false;
                    for (int x : duplicateNumbers) {
                        if (numbers[i] == x) {
                            existDuplicate = true;
                            break;
                        }
                    }
                    if (!existDuplicate) {
                        duplicateCount++;
                        duplicateNumbers[duplicateNumbersIndex++] = numbers[i];
                        break;
                    }
                }
            }
        }
        System.out.println("duplicateCount: " + duplicateCount);
        System.out.println();


        //ex.4
        char[] chars = {'բ', 'ա', 'ր', 'և', 'ա', 'շ', 'խ', 'ա', 'ր', 'հ'};
        char[] vowels = {'ա', 'ե', 'է', 'ը', 'ի', 'ո', 'օ'};
        int vowelsCount = 0;
        for (char c : chars) {
            for (char vowel : vowels) {
                if (c == vowel) {
                    vowelsCount++;
                    break;
                }
            }
        }
        System.out.println("vowelsCount: " + vowelsCount);


//        String text = "բարևաշխարհ";
//        String vowels = "աեէըիոուօ";
//        int count1 = 0;
//        for (int i = 0; i < text.length(); i++) {
//            char c = text.charAt(i);
//            if (vowels.indexOf(c) >= 0) {
//                count1++;
//            }
//        }
//        System.out.println(count1);
    }
}
