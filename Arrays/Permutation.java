//optimal approach becuase space complexity is O(1) as in place merging not creatig any other array
class Permutaion {
    public static void reverse(int[] nums, int piv){
        int n=nums.length;
        int i=piv+1;
        int j=n-1;
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void nextPermutation(int[] nums) {
        //finding pivot
        int n=nums.length;
        int piv=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                piv=i;
                break;
            }
        }
        if(piv==-1){
            reverse(nums,piv);
            return;
        }
        //swapping with rightmost element>pivot
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[piv]){
                swap(nums,i,piv);
                break;
            }
        }
        //reversing array from pivot+1 to n-1
        int i=piv+1;
        int j=n-1;
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
        // also we can reverse the array for step 3
        //reverse(nums,piv+1);

    }
}
