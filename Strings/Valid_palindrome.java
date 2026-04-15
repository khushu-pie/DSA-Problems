import java.util.*;
class Valid_palindrome {
    public boolean isAlphanumeric(char ch){
        char c=Character.toLowerCase(ch);
        if((c>='0' && c<='9' )|| (c>='a' && c<='z')){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int n=s.length();
        int st=0;
        int end=n-1;
        while(st<end){
            if(!isAlphanumeric(s.charAt(st))){
                st++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(end))){
                end--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(st))!=Character.toLowerCase(s.charAt(end))){
                return false;
               
            }
             st++;
                end--;
        }
        return true;
    }
}
