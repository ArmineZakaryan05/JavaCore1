package practice;

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "racecar";
        System.out.println(word + (isPalindrome(word) ? " is" : " is not") + " a palindrome.");
    }
}
