class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0; int rsum =0;
        // Sum of first window
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        // Remaining windows with left and right ptrs at ends
        int maxsum = lsum; int rindex = cardPoints.length - 1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rindex--];
            maxsum = Math.max(maxsum,lsum+rsum);
        }
        return maxsum;
    }
}

TC: O(2*N)
SC: O(1)
