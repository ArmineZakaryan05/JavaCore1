package practice;

public class StringReverser {
    public static String reverse(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverse(original);
        System.out.println("Reversed string: " + reversed);
    }
}
