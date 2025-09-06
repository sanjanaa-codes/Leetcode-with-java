//Solution - 1 

class Solution {
    public String reversePrefix(String word, char ch) {
        int i;
        StringBuilder sb = new StringBuilder();
        for( i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                sb.append(word.substring(0,i+1));
                break;
            }       
        }
        if(i==word.length()){
            return word;
        }
        sb.reverse();
        sb.append(word.substring(i+1,word.length()));
        return sb.toString();
    }
}

// Solution 2
class Solution {
    public String reversePrefix(String word, char ch) {
        int i;

        for (i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                StringBuilder sb = new StringBuilder(word.substring(0, i + 1));
                sb.reverse();
                sb.append(word.substring(i + 1));
                return sb.toString();
            }
        }
        return word;

    }
}

// Solution 3
