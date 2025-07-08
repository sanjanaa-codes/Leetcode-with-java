BRUTE

import java.util.*;

class Solution {
    private boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int count = 1;

            // Search for next consecutive numbers
            while (linearSearch(nums, x + 1)) {
                x++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}


---------------------------------------------------
BETTER

class Solution {
    public int longestConsecutive(int[] nums) {
          int n = nums.length;
        if (n == 0) return 0;

        Arrays.sort(nums);

        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }
}


---------------------------------------------------
OPTIMAL

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
