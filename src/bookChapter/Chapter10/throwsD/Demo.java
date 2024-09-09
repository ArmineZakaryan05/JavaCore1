package bookChapter.Chapter10.throwsD;

import static bookChapter.Chapter10.throwsD.ThrowsDemo.throwOne;

public class Demo {
    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Caught " + e);
        }
    }
}

