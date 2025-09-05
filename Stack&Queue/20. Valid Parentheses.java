class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if( (ch=='(') ||
                (ch=='{') ||
                (ch=='[') ) stack.push(ch);
            else{                                  //handles closing
                if(stack.isEmpty()) return false; //handles only opening braces
                char top = stack.pop();
                if( (ch==')' && top!='(') ||
                    (ch=='}' && top!='{') ||
                    (ch==']' && top!='[') ) return false;
            }
        }
        return stack.isEmpty();
    }
}

TC --> O(N)
SC --> O(N)
