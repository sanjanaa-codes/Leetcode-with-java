class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<first.length();i++){
            if(first.charAt(i)==last.charAt(i)){
                sb.append(first.charAt(i));
            }
            else{
                break;
            }
        }
        return sb.toString();
        
    }
}

Time Complexity: O(N·M·log N)
Sorting strs takes O(N·M·log N), where
N = number of strings
M = average or max string length (since comparisons scan characters) 

Space Complexity: O(M)

__________________________________________________________________________________________________________________________-
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null) return "";
        String str = strs[0];   //Storing the first element
        for(int i=1;i<strs.length;i++){
            while(! strs[i].startsWith(str)){
                str = str.substring(0,str.length() -1);
                if(str.isEmpty()) return "";
            }
        }
        return str;
    }
}

Time Complexity:

Worst-case scenario: prefix is reduced character by character across each of the N strings
Each startsWith runs in O(M), and you may do it up to M times per string
→ O(N·M²) in the worst case (e.g., all strings share a long common prefix then deviate late) 

Space Complexity:
→ O(1) 
