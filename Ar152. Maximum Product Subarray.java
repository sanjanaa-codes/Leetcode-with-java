🐢 1. Brute-Force (Nested Loops)

<---- n3 ---->  
class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= nums[k];
                }
                maxProduct = Math.max(maxProduct, prod);
            }
        }
        return maxProduct;
    }
}

  
Time Complexity: O(n³) in the worst case — three nested loops iterating over the array.
Space Complexity: O(1) — only constant extra variables are used.
  
<---- n2 ---->  
class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                maxProduct = Math.max(maxProduct, prod);
            }
        }

        return maxProduct;
    }
}

Time Complexity: O(N3)
Reason: We are using 3 nested loops for finding all possible subarrays and their product.

Space Complexity: O(1)
Reason: No extra data structure was used

✅ When to Use
Best suited for small arrays or as a starting point to reason about correctness.
Ideal for understanding problem structure before optimizing.
Not recommended for large constraints—LeetCode will likely run into TLE for n ≫ 200.
______________________________________________________________________________________________________________________________________________
🚀 2. Better (Two-Pass Prefix & Suffix O(n))

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix =1; int suffix =1;
        int maxi = nums[0];
        for(int i=0;i<n;i++){
            prefix = (prefix == 0? 1 : prefix)*nums[i];
            suffix = (suffix == 0? 1 : suffix)*nums[n-i-1];
            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }
        return maxi;
    }
}

  
Time: O(n) — single loop
Space: O(1) — only a few variables
✅ Efficient and able to handle zeros without losing track 
 
______________________________________________________________________________________________________________________________________________
⚡ Optimal (O(n)), DP with Max/Min Tracking (Kadane's Algo)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxSoFar = nums[0], minSoFar = nums[0], result = nums[0];

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            maxSoFar = tempMax;

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}

Time: O(n) — single traversal
Space: O(1) — fixed number of variables
🚀 Handles negatives and zero elegantly — the recommended solution 
