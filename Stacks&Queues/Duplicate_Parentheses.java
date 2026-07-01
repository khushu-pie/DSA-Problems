import java.util.Stack;

public class Duplicate_Parentheses {
    public static boolean findDuplicateParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the expression
        for (char c:s.toCharArray()) {
            char ch = c;

            // If it's a closing parenthesis, check what's inside
            if (ch == ')') {
                char top = stack.peek();
                
                // If the top element is immediately '(', it means nothing 
                // was inside this pair -> Duplicate/Redundant found!
                if (top == '(') {
                    return true;
                }
                
                // Otherwise, pop elements until we find the matching '('
                while (stack.peek() != '(') {
                    stack.pop();
                }
                
                // Pop the matching '(' itself out of the stack
                stack.pop();
            } 
            // Push all other characters (opening brackets, letters, operators)
            else {
                stack.push(ch);
            }
        }

        // If we finish the loop without returning true, no duplicates exist
        return false;
    }

    public static void main(String[] args) {
        String expr1 = "((a+b)+(c+d))"; // No duplicates
        String expr2 = "(((a+b)))";     // Has duplicates

        System.out.println("Expression 1 has duplicates: " + findDuplicateParentheses(expr1));
        System.out.println("Expression 2 has duplicates: " + findDuplicateParentheses(expr2));
    }
}