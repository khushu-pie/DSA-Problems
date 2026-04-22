class Solution {
    public int lengthOfLongestSubstring(String s) {
        //sliding window -> two-pointer approach
        boolean alpha[]=new boolean[256];
        int maxlen=0;
        int st=0;
        for(int end=0;end<s.length();end++){
            char curr=s.charAt(end);
            while(alpha[curr]){//if character exists then shrinking the left window
                alpha[s.charAt(st)]=false;
                st++;
            }
            //character not present
            alpha[curr]=true;
            int len=end-st+1;
            maxlen=Math.max(maxlen,len);
    }
    return maxlen;
}
}
