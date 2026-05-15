class TwoStacks {
    private int[] arr;
    private int size;
    private int top1, top2;

    // Constructor
    public TwoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;       // Points to the top of the first stack
        top2 = size;     // Points to the top of the second stack
    }

    // Push element into Stack 1
    public void push1(int x) {
        // Check if there is at least one empty space between the stacks
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow in Stack 1");
        }
    }

    // Push element into Stack 2
    public void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow in Stack 2");
        }
    }

    // Pop element from Stack 1
    public int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow in Stack 1");
            return -1;
        }
    }

    // Pop element from Stack 2
    public int pop2() {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow in Stack 2");
            return -1;
        }
    }
}
