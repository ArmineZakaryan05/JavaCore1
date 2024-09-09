package bookChapter.Chapter10.throwsD;

public class ThrowsDemo {
    static void throwOne() throws IllegalAccessException{
         {
            System.out.println("Inside throwOne.");
            throw new IllegalAccessException("demo");
        }
    }
}