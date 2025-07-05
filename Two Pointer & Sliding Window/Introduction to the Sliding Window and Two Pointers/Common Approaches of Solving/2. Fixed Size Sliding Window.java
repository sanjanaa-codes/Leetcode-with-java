
Description:
Efficiently process all subarrays of a fixed size k by updating the sum as the window slides. The fixedWindowMaxSum method finds the maximum sum of any subarray of size k using the sliding window technique.

📌 Example:
Let’s say:
int[] arr = {2, 1, 5, 1, 3, 2};
int k = 3;

You want to find the maximum sum of any 3 consecutive elements in the array.

✅ Step-by-step Walkthrough:

1️⃣ Initialization:
int n = arr.length; // 6
int maxSum = 0;
int windowSum = 0;

2️⃣ First window sum (i = 0 to k-1):
for (int i = 0; i < k; i++) windowSum += arr[i];

So, windowSum = 2 + 1 + 5 = 8

maxSum = windowSum; // maxSum = 8

3️⃣ Slide the window:
Now slide the window one element at a time.
i = 3:
windowSum = windowSum + arr[3] - arr[0]; // 8 + 1 - 2 = 7
maxSum = Math.max(8, 7) = 8
i = 4:
windowSum = 7 + 3 - 1 = 9
maxSum = Math.max(8, 9) = 9
i = 5:
windowSum = 9 + 2 - 5 = 6
maxSum = Math.max(9, 6) = 9
return maxSum; // 9

🔁 Subarrays considered:
{2, 1, 5} → sum = 8

{1, 5, 1} → sum = 7

{5, 1, 3} → sum = 9 ✅

{1, 3, 2} → sum = 6

🔍 Summary:
The function efficiently calculates the maximum sum of any fixed-size (k) window in an array by:

Calculating the first window sum

Sliding the window by 1 element each time (adding next, removing previous)

Tracking the max sum along the way

🧠 Time Complexity: O(n)
📦 Space Complexity: O(1)
