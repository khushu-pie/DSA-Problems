import java.util.HashSet;

public class LongestConsecutiveIntgegerLength {
    public static int longest_consecuitve_integers(int[] arr){
        HashSet<Integer> set = new HashSet<>();

for (int x : arr)
    set.add(x);

int maxLen = 0;

for (int x : set) {
    if (!set.contains(x - 1)) {
        int curr = x;
        int len = 1;

        while (set.contains(curr + 1)) {
            curr++;
            len++;
        }

        maxLen = Math.max(maxLen, len);
    }
}

return maxLen;
    }
    public static void main(String[] args){
        int[] arr={200,4,100,3,2,1};
        System.out.println(longest_consecuitve_integers(arr));
    }
}
