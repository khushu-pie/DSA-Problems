import java.util.Stack;

public class InfixToPostfix {
    
    // Function to return precedence of operators
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    // Function to check if operator is right-associative
    static boolean isRightAssociative(char c) {
        return c == '^';
    }

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If operand, add to result
            if (Character.isLetterOrDigit(c))
                res.append(c);

            // If '(', push to stack
            else if (c == '(')
                st.push('(');

            // If ')', pop until '( '
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                // Pop and discard the matching left parenthesis '('
                st.pop();
            }

            // If operator
            else {
                // Pop operators from stack and append to output if they have 
                // higher or equal precedence than the current operator 'c'
                while (!st.isEmpty() && st.peek() != '(' &&
                       (prec(st.peek()) > prec(c) ||
                       (prec(st.peek()) == prec(c) && !isRightAssociative(c)))) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String exp = "a*(b+c)/d";
        System.out.println(infixToPostfix(exp));
    }
}