Given an array arr and a target k, find the longest contiguous subarray where the sum of its elements is less than or equal to k.

public int variableWindowLongestSubarray(int[] arr, int k) {
    int n = arr.length, left = 0, windowSum = 0, maxLen = 0;
    for (int right = 0; right < n; right++) {
        windowSum += arr[right];
        while (windowSum > k && left <= right) {
            windowSum -= arr[left++];
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}


  
✅ Example:
int[] arr = {1, 2, 1, 0, 1, 1, 0};
int k = 4;

🔁 Step-by-Step Execution:
We maintain a window between left and right and keep track of the sum inside that window.

Initial state:
left = 0, right = 0, windowSum = 0, maxLen = 0

Iterations:
right = 0:

windowSum = 1

≤ 4, so maxLen = 1

right = 1:

windowSum = 1 + 2 = 3

≤ 4, so maxLen = 2

right = 2:

windowSum = 3 + 1 = 4

≤ 4, so maxLen = 3

right = 3:

windowSum = 4 + 0 = 4

≤ 4, so maxLen = 4

right = 4:

windowSum = 4 + 1 = 5

4 → Shrink from left:

windowSum -= arr[0] = 5 - 1 = 4

left = 1

Now valid → maxLen = 4 (no change)

right = 5:

windowSum = 4 + 1 = 5

4 → Shrink:

windowSum -= arr[1] = 5 - 2 = 3

left = 2

Valid → maxLen = 4

right = 6:

windowSum = 3 + 0 = 3

Valid → maxLen = 5 ✅

✅ Final Output:
return maxLen; // 5


🔍 Summary:
This method: Grows the window to the right (right++)
Shrinks the window from the left (left++) when the sum exceeds k
Keeps track of the maximum valid window length

🧠 Complexity:
Time: O(n)
Space: O(1)
