//to find minimum amd maximum element in an array and return a arraylist of those elements
import java.util.ArrayList;
class Minmax {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        boolean swap;
        for(int i=0;i<arr.length;i++){
            int min=arr[i];
            swap=false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    swap=true;
                }
            }
            
        }
        ArrayList<Integer> minmax=new ArrayList<>();
        minmax.add(arr[0]);
        minmax.add(arr[arr.length-1]);
        return minmax;
    }
}
