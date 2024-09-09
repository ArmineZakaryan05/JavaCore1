package homework;

public class ForIfExamples {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        System.out.println();


        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
        System.out.println();


        for (int i = 50; i > 0; i--) {
            System.out.print(i + " ");

        }
        System.out.println();
        System.out.println();


        for (int i = 1; i < 20; i = i + 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();


        int count = 0;
        for (int i = 2; i < 101; i = i + 2) {
            count++;
        }
        System.out.println(count + " ");
    }
}
