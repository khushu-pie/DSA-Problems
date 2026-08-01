//we can also cretae a min-heap and then add all numbers to the mi  heap, the run a loop on it for k-1 times
//then we can return heap.peek(), here TC:)(N+klogN)
//N for building the heap and KlogN for extracting elements from min-heap
//quickselect is an optimised approach having TC:O(N) in worst-case O(N^2)
class Kth_smallestElement {

    static int partition(int[] arr, int left, int right) {
        
         // Choose the last element as pivot
        int pivot = arr[right]; 
        int i = left; 

        // Traverse the array and move elements <= pivot to the left
        for(int j = left; j < right; j++) {
            if(arr[j] <= pivot) {
                
                 // Swap current element with element at i
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;                  
            }
        }

        // Place the pivot in its correct position
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }

    static int quickSelect(int[] arr, int left, int right, int k) {
        
        if(left <= right) {
            
            // Partition around pivot
            int pivotIndex = partition(arr, left, right); 
            
             // Found k-th smallest
            if(pivotIndex == k) return arr[pivotIndex];  
            
            else if(pivotIndex > k) 
            return quickSelect(arr, left, pivotIndex - 1, k);
            
            else return quickSelect(arr, pivotIndex + 1, right, k);
        }
        return -1;
    }

    static int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length-1, k-1);
    }

    public static void main(String[] args) {
        int[] arr = {10,5,4,3,48,6,2,33,53,10};
        int k = 4;
        System.out.println(kthSmallest(arr, k));
    }
}
