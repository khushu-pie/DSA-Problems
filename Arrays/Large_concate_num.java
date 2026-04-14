//finding large possible number that can be formed after concatenating the numbers of given array
import java.util.*;
class Large_concate_num {
    public String findLargest(int[] arr) {
        // code here
        int n=arr.length;
        String[] s=new String[n];
        for(int i=0;i<n;i++){
            s[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(s,(a,b)->(b+a).compareTo(a+b));
        StringBuilder sb=new StringBuilder();
        for(String str:s){
            sb.append(str);
        }
        String res=sb.toString();
        if(res.startsWith("0")){
            return "0";
        } else{
            return res;
        }
    }
}
