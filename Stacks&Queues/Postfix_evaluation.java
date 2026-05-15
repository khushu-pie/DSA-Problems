import java.util.Stack;
class Solution {
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> s=new Stack<>();
        for(String token:arr){
            if(isOperator(token)){
                int val1=s.pop();
                int val2=s.pop();
                switch(token){
                    case "+":s.push(val2+val1); break;
                    case "-":s.push(val2-val1); break;
                    case "*":s.push(val2*val1); break;
                    case "/":s.push(Math.floorDiv(val2,val1)); break;
                    case "^":s.push((int)Math.pow(val2,val1)); break;
            }
        } else {
            s.push(Integer.parseInt(token));
        }
        
    }
    return s.pop();
}
}
