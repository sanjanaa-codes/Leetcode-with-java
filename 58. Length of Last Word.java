🐢 1. Brute‑Force (Split)
  
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] sarray = s.split("\\s+");
        return sarray[sarray.length -1].length();
    }
}

Time: O(n) — trim + split 
Space: O(n) — array allocation

  
                  <----------NOTE---------->
\\s+ => all whitespaces and non-visible characters
st.replaceAll("\\s+","") removes all whitespaces and non-visible characters (e.g., tab, \n).
The trim() method is a built-in function in Java that removes leading and trailing whitespace from a string. 
____________________________________________________________________________________________________________________
🚶 2. Better (Trim + lastIndexOf)

class Solution {
    public int lengthOfLastWord(String s) {
       s = s.trim();
       int lastSpace = s.lastIndexOf(' ');
       return s.length()-lastSpace -1; 
    }
}

Time: O(n)
Space: O(1)
____________________________________________________________________________________________________________________
⚡ 3. Optimal (Single Scan, Reverse)

class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        int len = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }
}

Time: O(n) — single linear pass 
Space: O(1)


____________________________________________________________________________________________________________________
