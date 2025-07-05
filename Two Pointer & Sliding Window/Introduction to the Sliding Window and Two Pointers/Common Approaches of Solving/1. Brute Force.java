Check every possible subarray/subsequence using nested loops.

public int bruteForceMaxSum(int[] arr, int k) {
    int n = arr.length, maxSum = Integer.MIN_VALUE;
    for (int i = 0; i <= n - k; i++) {
        int sum = 0;
        for (int j = i; j < i + k; j++) {
            sum += arr[j];
        }
        maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
}

Time Complexity: 
O(nk) (or) O(n2) for variable window)

Space Complexity: 
O(1)

  
