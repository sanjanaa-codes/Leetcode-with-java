The maximum product of three numbers will either be:
-> Product of the three largest numbers (all positives), or
-> Product of the two smallest (possibly negative) numbers and the largest number (e.g., -10 × -10 × 5)

public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;

    int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
    int option2 = nums[0] * nums[1] * nums[n - 1];

    return Math.max(option1, option2);
}

⏱ Time & Space Complexity:
Time: O(n log n) – due to sorting
Space: O(1) – constant extra space

--------------------------------------------------------------------------------------------------------------------------------
(True Optimal – Linear Time):

If you don’t want to sort (to get O(n) time), manually track the top 3 max and 2 min values:

public int maximumProduct(int[] nums) {
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

    for (int n : nums) {
        // max values
        if (n > max1) {
            max3 = max2;
            max2 = max1;
            max1 = n;
        } else if (n > max2) {
            max3 = max2;
            max2 = n;
        } else if (n > max3) {
            max3 = n;
        }

        // min values
        if (n < min1) {
            min2 = min1;
            min1 = n;
        } else if (n < min2) {
            min2 = n;
        }
    }

    return Math.max(max1 * max2 * max3, min1 * min2 * max1);
}

