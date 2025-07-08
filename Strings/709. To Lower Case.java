   
✅ 1. Use String.toLowerCase()
    
class Solution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
Time -> O(N)
Space -> O(N)
===============================================================================
✅ 2. Using StringBuilder
    
class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

Time -> O(N)
Space -> O(N)

Since String is immutable in Java, toLowerCase() returns a new string.
That means it uses O(n) space to store the result.

✅LESSER LINES USING TERNARY
class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sb.append(Character.isUpperCase(ch) ? Character.toLowerCase(ch) : ch);
        }
        return sb.toString();

    }
}
----------------------------------------------------------------------------------------------------------------------
