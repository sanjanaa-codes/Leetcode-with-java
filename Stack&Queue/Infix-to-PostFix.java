import java.util.Stack;

public class Solution {
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                res.append(c);
            } 
            else if (c == '(') {
                st.push(c);
            } 
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } 
            else {
                while (!st.isEmpty() && priority(c) <= priority(st.peek())) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }

     public static int priority(char c) {
        if (c == '^') return 3;
        else if (c == '/' || c == '*') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }
}


