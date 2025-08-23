class Solution {
    public String firstPalindrome(String[] words) {
        for(String i:words){
            if(isPalindrome(i)){
                return i;
            }
        }
        return "";
    }
    
    public boolean isPalindrome(String word){
        StringBuilder sb = new StringBuilder(word);
        String news = sb.reverse().toString();
        return news.equals(word);
    }
}
