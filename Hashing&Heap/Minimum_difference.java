//Given an array arr[] of n integers. The task is to pick exactly m elements such that the maximum difference between any pair of these m elements in minimum.
import java.util.Arrays;
public class Minimum_difference{
    public static int FindminDiff(int[] arr, int m){
        int minDiff=Integer.MAX_VALUE;
        int n=arr.length;
        if(m==0 || n==0 || n<m){
            return 0;
        }
        //1.sort the array in ascending order
        Arrays.sort(arr);
        //2.create sliding window of size m
        for(int i=0;i<=n-m;i++){
              int currentDiff=arr[i+m-1]-arr[i];//difference between larhest and smallest element in that paticular sliding window
              //tracking the minimum distance so far
              if(currentDiff<minDiff){
                minDiff=currentDiff;
              }
        }
        return minDiff;
    }
    public static void main(String[] args){
        int arr[]={7,3,2,4,9,12,56};
        int res=FindminDiff(arr, 3);
        System.out.println("The minimum difference:"+res);
    }
}