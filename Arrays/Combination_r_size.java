//given an array and need to find all combinations of size r from that array
import java.util.*;

public class Main {
    public static void generateCombinations(int[] arr, int r) {
        // Sort to handle potential duplicates if required by the problem
        Arrays.sort(arr);
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(arr, r, 0, currentCombination);
    }

    private static void backtrack(int[] arr, int r, int start, List<Integer> temp) {
        // Base case: If we have picked exactly r elements
        if (temp.size() == r) {
            for (int num : temp) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // Iterate through the array starting from 'start' index
        for (int i = start; i < arr.length; i++) {
            // To handle duplicate elements in input (ensure uniqueness)
            if (i > start && arr[i] == arr[i - 1]) continue;

            // 1. Include the element
            temp.add(arr[i]);

            // 2. Move to the next index (i + 1)
            backtrack(arr, r, i + 1, temp);

            // 3. Backtrack: Remove the element to explore other possibilities
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 2;
        generateCombinations(arr, r);
    }
}
