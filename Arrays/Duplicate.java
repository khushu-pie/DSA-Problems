import java.util.HashSet;
class Duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> vis=new HashSet<>();
        for(int num:nums){
            if(vis.contains(num)){//check if element is already present
                return true;
            }
            vis.add(num);//if element dosen't exist add in set
        }
        return false;//no dupliactes found
        
    }
}
