class Solution {
    public boolean canAliceWin(int n) {
        int remove= 10;
        int a = 0;  //alice starts
        while(n>=remove){
            n-=remove;
            remove--;
            a++;
        }
        return a%2!=0;
    }
}
// n - 12, 2
// remove - 10, 9
// a - 1 (alice) , 3(alice)
// a - 2 (bob) , 4(bob)

⏱️ Time Complexity : O(√n)
🧠 Space Complexity : O(1) 
