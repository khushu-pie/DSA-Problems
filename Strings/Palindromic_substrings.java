import java.util.ArrayList;
public class Palindromic_substrings {
    // Processes queries and returns a list of 1s (palindrome) and 0s (not palindrome)
    public static ArrayList<Integer> substring(String s, int[][] query) {
        int n = query.length; // FIXED: Used .length instead of .size() for 2D array
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int left = query[i][0];
            int right = query[i][1]; // FIXED: Corrected spelling from 'rigth' to 'right'

            // Check if the substring from index 'left' to 'right' is a palindrome
            if (isPalindrome(s, left, right)) {
                res.add(1);
            } else {
                res.add(0);
            }
        }

        return res; // FIXED: Added missing return statement
    }

    // Two-pointer method to check if a substring s[left...right] is a palindrome
    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            // FIXED: Replaced '!s.charAt(left) == s.charAt(right)' with '!='
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abaaabaaaba";

        // FIXED: Corrected 2D array initialization syntax
        int[][] query = {
            {0, 10},
            {5, 8},
            {2, 5},
            {5, 9}
        };

        ArrayList<Integer> res = substring(s, query);

        // Print results separated by space
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
    //this is an naive approach
    

