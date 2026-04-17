import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            } else{
                if(st.size()==0){//corner case when closing brackets are greater than opening brackets
                    return false;
                }
                if((s.charAt(i)==')' && st.peek()=='(')||(s.charAt(i)=='}' && st.peek()=='{')|| (s.charAt(i)==']' && st.peek()=='[')){
                    st.pop();
                } else{
                    return false;
                }
            }
        }
        return st.size()==0;//corner case when opening brackets are greater than closing brackets
            
        
    }
    
}
