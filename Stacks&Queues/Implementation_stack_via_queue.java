class MyStack {
    Queue<Integer> q=new LinkedList<>();
        int front, rear;

    public MyStack() {
    }
    
    public void push(int x) {
        q.add(x);
        for(int i=1;i<q.size();i++){
            q.add(q.remove());//since queue is FIFO and stack is LIFO so we need add the elements in reverse order so first we will remove the added element and then add it to make it in reverse order
        }
    }
    
    public int pop() {
       if(empty()){
        return -1;
       }
       return q.remove();
    }
    
    public int top() {
        if(empty()){
            return -1;
        }
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
