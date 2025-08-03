class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxi = 0, sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];

            }
            maxi = Math.max(maxi, sum);
            sum = 0;
        }
        return maxi;
    }
}
