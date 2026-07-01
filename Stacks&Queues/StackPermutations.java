import java.util.Stack;
public class StackPermutations {
    public static boolean CheckPermutaion(int[] a, int[] b) {
      
        Stack<Integer> s=new Stack<>();
        int j=0;//pointer for index of array b
        for(int i=0;i<a.length;i++){
            //first push the first element from array a
            s.push(a[i]);
            //comparing the element with b and then poping matched element
            while(!s.isEmpty()&&s.peek()==b[j]){
                s.pop();
                j++;//incrementing array b pointer
            }
        }
        return (j==b.length);//it means the whole b array has traversed and valid opertaions are found
    }
    public static void main(String[] args){
        int[] a={1,2,3};
        int[] b={2,1,3};
        System.out.println(CheckPermutaion(a,b)?"true":"false");
    }
}