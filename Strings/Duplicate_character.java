
import java.util.*;
class Duplicate_character {
    public static void duplicate(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char key=s.charAt(i);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            } else{
                map.put(key,1);
            }
        }
        for(Map.Entry<Character,Integer> it:map.entrySet()){
            if(it.getValue()>1){
                System.out.print("['"+it.getKey()+"',"+it.getValue()+"]");
            }
        }
    }
    public static void main(String[] args) {
        String s="geeksforgeeks";
        duplicate(s);
    }
}
