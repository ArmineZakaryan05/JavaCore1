package bookChapter.Chapter10.throwE;

public class ThrowDemo {
    static void demoproc(){
        try {
            throw new NullPointerException("demo");
        }catch (NullPointerException e){
            System.out.println("Caught inside demoproc.");
            throw e;
        }
    }
}
