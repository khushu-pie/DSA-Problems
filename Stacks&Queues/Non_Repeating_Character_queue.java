import java.util.LinkedList;
import java.util.Queue;

public class Non_Repeating_Character_queue {

    public static String findFirstNonRepeating(String str) {
        // Frequency array for 26 lowercase English letters
        int[] count = new int[26];
        
        // Queue to maintain the order of characters
        Queue<Character> q = new LinkedList<>();
        
        // StringBuilder to accumulate the result for each step in the stream
        StringBuilder result = new StringBuilder();

        // Process each character in the stream one by one
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 1. Update frequency and add to queue
            count[ch - 'a']++;
            q.add(ch);

            // 2. Clean up the queue from the front
            // Remove characters that have repeated (frequency > 1)
            while (!q.isEmpty() && count[q.peek() - 'a'] > 1) {
                q.poll(); 
            }

            // 3. The front of the queue is now our first non-repeating character
            if (q.isEmpty()) {
                result.append('#'); // No non-repeating character exists
            } else {
                result.append(q.peek());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "aabc";
        System.out.println("Stream: " + str);
        System.out.println("Result: " + findFirstNonRepeating(str));
    }
}