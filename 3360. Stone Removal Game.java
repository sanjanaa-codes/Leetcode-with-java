class Solution {
    public boolean canAliceWin(int n) {
        int num = 10;
        int a=0;
        while(n>=num){
            n-=num;
            num--;
            a++;
        }
        return a%2 !=0;
    }
}

⏱️ Time Complexity : O(√n)
🧠 Space Complexity : O(1) 
