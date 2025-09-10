class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

Time Complexity:

Iterating over all characters → O(n)
Each character is pushed/popped at most once → O(n)
Building + reversing string → O(n)
✅ Total = O(n)

Space Complexity:

Stack can hold up to n characters in the worst case → O(n)
StringBuilder used for result → O(n)
✅ Total = O(n)
_______________________________________________________________________________________________


_______________________________________________________________________________________________
