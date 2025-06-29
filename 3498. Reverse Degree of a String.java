class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
       for(int i=0;i<s.length();i++){
         int reversedalpha = 26 - (s.charAt(i)-'a');
         sum += reversedalpha*(i+1);
       }
        return sum;
    }
}

Time Complexity: O(n), single pass through s 
Space Complexity: O(1), uses only a few variables
