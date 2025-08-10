class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i=0;i<k;i++){
            sb.append(arr[i]+" ");
        }
        return sb.toString().trim();
    }
}

Time Complexity:
split(" ") → O(n) (n = length of string)
Loop runs k times → O(k)
Overall: O(n + k) → simplifies to O(n) since k ≤ number of words ≤ n

Space Complexity:
split stores all words → O(n) extra
StringBuilder → O(n)
Overall: O(n+n) → O(n)
-----------------------------------------------------------------------------------------------------------

class Solution {
    public String truncateSentence(String s, int k) {
        int space = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && space < k) {
                space++;

            }
            if (space == k) {
                break;
            }

            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}


Time Complexity:
Single loop through string until kth space → worst case O(n)

Space Complexity:
Only StringBuilder → O(n) (output string)
Overall: O(n) (but no extra array like in split, so memory use is less than approach 1)
