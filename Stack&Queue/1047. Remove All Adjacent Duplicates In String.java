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
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

⏱ Time Complexity (TC)

You iterate through s once → O(n).
But careful: sb.deleteCharAt(sb.length() - 1) is O(1) (deleting from the end of StringBuilder is constant time).
sb.append() is also O(1) amortized.
👉 So overall: O(n)

💾 Space Complexity (SC)
                    
You’re using StringBuilder as the stack.
👉 So overall: O(1) extra (just the output storage)
_______________________________________________________________________________________________
