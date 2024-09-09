package homework.braceChecker;

import java.util.Scanner;

public class BraceCheckerTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input text! ");
        String text = scanner.nextLine();

        BraceChecker bc = new BraceChecker(text);
        bc.check();
    }
}
