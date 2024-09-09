package bookChapter.Chapter10.throwE;

import static bookChapter.Chapter10.throwE.ThrowDemo.demoproc;

public class Demo {
    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Recaught: " + e);
        }
    }
}
