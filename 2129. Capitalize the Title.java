class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        
        String[] str = title.toLowerCase().split(" ");

        for(int i=0;i<str.length;i++){

            if(str[i].length()<=2){
                sb.append(str[i]);
            }

            else{
                sb.append(str[i].substring(0,1).toUpperCase());
                sb.append(str[i].substring(1,str[i].length()));

            }
            if(i != str.length-1){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}

Time - O(n)
Space - O(n)

------------------------------------------------------------------------------------------------------
