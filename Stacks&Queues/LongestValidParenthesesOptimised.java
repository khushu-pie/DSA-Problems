public class LongestValidParenthesesOptimised {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0, right = 0, maxLength = 0;

        // 1. Pass from Left to Right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            // When open and close match, we have a valid substring
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } 
            // If we have more close brackets than open, reset counters
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        // Reset counters for the reverse pass
        left = 0;
        right = 0;

        // 2. Pass from Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            // When open and close match, we have a valid substring
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } 
            // If we have more open brackets than close, reset counters
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println("Max valid length: " + longestValidParentheses(s));
    }
}