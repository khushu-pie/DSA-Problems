/*Given a stream of characters (characters are received one by one), write a function that prints 'Yes' if a character makes the complete string palindrome, else prints 'No'. 
Input: str[] = "abcba"
Output: a Yes   // "a" is palindrome
        b No    // "ab" is not palindrome
        c No    // "abc" is not palindrome
        b No    // "abcb" is not palindrome
        a Yes   // "abcba" is palindrome 
        // */
public class Check_palindromeStream {
    public static void solution(String str) {
        StringBuilder sb = new StringBuilder();

        // Process characters one by one
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);

            // Check if current prefix is a palindrome
            if (isPalindrome(sb.toString())) {
                System.out.println("Char: '" + ch + "' -> Yes");
            } else {
                System.out.println("Char: '" + ch + "' -> No");
            }
        }
    }

    // Helper method to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }
        return true; // All characters matched
    }

    public static void main(String[] args) {
        String str = "abcba";
        solution(str);
    }
}
