// given a string of capital letters and we need to convert it into respective numeric of mobile keypad
class Solution {
    String printSequence(String S) {
        
        String[] alpha={"2","22","222","3","33","333","4","44","444","5","55","555","6","66","666","7","77","777","7777","8","88","888","9","99","999","9999"};
        StringBuilder res=new StringBuilder();
        for(int i=0;i<S.length();i++){
            char currchar=S.charAt(i);
            if(currchar==' '){
                res.append(currchar);
            } else if(currchar>='A' && currchar<='Z'){
            int idx=Math.abs(currchar-'A');
            res.append(alpha[idx]);
        }
        }
        return res.toString();
    }
}
