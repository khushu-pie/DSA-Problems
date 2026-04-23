//optimistaion can be done using dyanamic programming
class Solution {
    public boolean ispalindrome(String s, int left, int right){
        while(left<right){
            char c1=s.charAt(left);
            char c2=s.charAt(right);
            if(c1!=c2){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int max=0,start=0,end=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(ispalindrome(s,i,j)){
                    int len=j-i+1;
                    if(len>max){
                        max=j-i+1;
                        start=i;
                        end=j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
