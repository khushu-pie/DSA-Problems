//given array of strings, we need to find common longest prefix(can also be done using trie data structure)
class Solution {
    public String common(String s, String t){
        int n=Math.min(s.length(),t.length());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)==t.charAt(i)){
                sb.append(s.charAt(i));
            } else{
                break;
            }
        }
        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        String res=strs[0];
        for(int i=1;i<strs.length;i++){
            res=common(res,strs[i]);
        }
        return res;
    }
}
