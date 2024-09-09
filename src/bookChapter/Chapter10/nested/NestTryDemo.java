package bookChapter.Chapter10.nested;

import static bookChapter.Chapter10.nested.MethNestTry.nesttry;

public class NestTryDemo {
    public static void main(String[] args) {
        try {
            int a = args.length;
            int b = 42 / a;
            System.out.println("a = " + a);
            nesttry(a);
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0:" + e);
        }
    }
}
