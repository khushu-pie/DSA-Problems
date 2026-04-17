//by using stack TC:O(n) and SC:O(n) but by using StringBuilder TC remains same but SC:O(1)
import java.util.Stack;
class Solution {
    public String removeConsecutiveCharacter(String s) {
        
    //     Stack<Character> s1=new Stack<>();
        
    //     s1.push(s.charAt(0));
    //     for(int i=1;i<s.length();i++){
    //         if(s1.peek()!=s.charAt(i)){
    //             s1.push(s.charAt(i));
    //     } 
    //     }
    //     StringBuilder sb=new StringBuilder();
    //     while(!s1.isEmpty()){
    //         sb.append(s1.pop());
    //     }
    //     return sb.reverse().toString();
           StringBuilder sb=new StringBuilder();
           sb.append(s.charAt(0));
           for(int i=1;i<s.length();i++){
               if(s.charAt(i)!=s.charAt(i-1)){
                   sb.append(s.charAt(i));
               }
           }
           return sb.toString();
        
    }
}
