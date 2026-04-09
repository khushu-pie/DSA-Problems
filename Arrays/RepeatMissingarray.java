public class Solution {
    public int[] repeatedNumber(final int[] A) {
        long n = A.length;
        
        // Sum of first n numbers: n(n+1)/2
        long expectedSum = (n * (n + 1)) / 2;
        // Sum of squares of first n numbers: n(n+1)(2n+1)/6
        long expectedSumSq = (n * (n + 1) * (2 * n + 1)) / 6;
        
        long actualSum = 0;
        long actualSumSq = 0;
        
        for (int x : A) {
            long val = (long) x;
            actualSum += val;
            actualSumSq += (val * val);
        }
        
        // Diff1 = A - B
        long diffSum = actualSum - expectedSum;
        
        // Diff2 = A^2 - B^2 = (A - B)(A + B)
        long diffSumSq = actualSumSq - expectedSumSq;
        
        // (A + B) = (A^2 - B^2) / (A - B)
        long sumAB = diffSumSq / diffSum;
        
        // A = ((A - B) + (A + B)) / 2
        int repeated = (int) ((diffSum + sumAB) / 2);
        // B = (A + B) - A
        int missing = (int) (sumAB - repeated);
        
        return new int[]{repeated, missing};
    }
}
