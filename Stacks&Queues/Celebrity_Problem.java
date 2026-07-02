//optimised approch TC:O(n^2) SC:O(1)
//naive approach is comparing each row element with each column element TC:O(n^2) and SC:O(1)
public class Celebrity_Problem {

    public static int findCelebrity(int[][] mat, int n) {
        // Step 1: Use two pointers to find the celebrity candidate
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (mat[left][right] == 1) {
                // If left knows right, left cannot be a celebrity. Move to next.
                left++;
            } else {
                // If left doesn't know right, right cannot be a celebrity.
                right--;
            }
        }

        // 'left' (or 'right', since left == right) is our single potential candidate
        int candidate = left;//here u can also right candidate=right because only songle potential candidate

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            // Skip checking the candidate against themselves
            if (i != candidate) {
                // A celebrity must not know anyone (mat[candidate][i] must be 0)
                // AND everyone must know the celebrity (mat[i][candidate] must be 1)
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1; // Verification failed
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };
        int n = mat.length;
        
        int result = findCelebrity(mat, n);
        System.out.println("The celebrity index is: " + result);
    }
}