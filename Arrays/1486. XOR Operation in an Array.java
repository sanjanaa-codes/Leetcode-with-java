class Solution {
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = start + 2 * i;
        }
        int res = arr[0];
        for (int i = 1; i < n; i++) {
            res ^= arr[i];
        }
        return res;

    }
}
