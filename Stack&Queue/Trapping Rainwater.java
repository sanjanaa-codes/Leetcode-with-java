For optimum approach
________________________________
Intuition Behind the Problem:

-> The goal is to calculate how much rainwater can be trapped between the bars in an elevation map. 
The amount of water trapped at any point depends on the height of the current bar and the height 
of the tallest bars to its left and right.

-> Water can only be trapped if there are taller bars on both the left and right sides of the current bar.

-> The amount of water trapped at a specific bar is determined by the minimum of the tallest bars on its left and right, 
minus the height of the current bar.
  
________________________________
Key Insight:
-> The water trapped at any point depends on the lower of the two tallest bars 
  (one on the left and one on the right). 
    This is because water will overflow from the shorter side.

-> If the tallest bar on the left is smaller than the tallest bar on the right, the water 
level at the current position cannot exceed the height of the left tallest bar.

-> Similarly, if the tallest bar on the right is smaller, the water level cannot exceed the 
height of the right tallest bar.

________________________________
How the Two-Pointer Approach Works?
The two-pointer approach is a clever way to solve this problem in O(1) space by using two pointers 
(one at the start and one at the end of the array) and tracking the tallest bars seen so far from both sides.

________________________________
Step-by-Step Intuition:

1. Initialize Two Pointers:
2. left starts at the beginning of the array.
3. right starts at the end of the array.
4. Track the Tallest Bars:
  A. left_max: The tallest bar seen so far from the left side.
  B. right_max: The tallest bar seen so far from the right side.
5. Move the Pointers:
6. Compare the heights at the left and right pointers:
  A. If height[left] < height[right]:
      This means the water level at the left pointer is limited by left_max (the tallest bar on the left so far).
  B. If the current height[left] is greater than or equal to left_max, update left_max (no water can be trapped here).
  C. Otherwise, add the difference (left_max - height[left]) to the total water trapped.
7. Move the left pointer to the right.
  A. If height[left] >= height[right]:
       This means the water level at the right pointer is limited by right_max (the tallest bar on the right so far).
  B. If the current height[right] is greater than or equal to right_max, update right_max (no water can be trapped here).
  C. Otherwise, add the difference (right_max - height[right]) to the total water trapped.
8. Move the right pointer to the left.
9. Repeat Until Pointers Meet:
10.Continue this process until the left and right pointers meet. At this point, you’ve considered all bars and calculated 
  the total trapped water.

________________________________
Why This Works?
  
-> By moving the pointers based on the comparison of height[left] and height[right], you ensure that you’re 
-> always considering the lower of the two tallest bars (either left_max or right_max) to determine the water level.
This approach avoids the need for additional arrays or data structures, making it space-efficient (O(1)).
________________________________

Trapping Rain Water — two-pointer walkthrough (step-by-step)

Array (indices → heights):
index: 0 1 2 3 4 5 6 7 8 9 10 11
heights: 0 1 0 2 1 0 1 3 2 1 2 1

Algorithm rule (two-pointer): keep l at left, r at right, maintain lmax and rmax.
While l < r: compare heights[l] and heights[r].

If heights[l] < heights[r] → process l: if heights[l] >= lmax set lmax = heights[l], else water += lmax - heights[l]; then l++.

Else → process r: if heights[r] >= rmax set rmax = heights[r], else water += rmax - heights[r]; then r--.

Below are the exact steps (showing l, r, values before calculation, action, water added, running total):

________________________________

| Step |  l |  r | h\[l] | h\[r] | lmax (before) | rmax (before) | Action (what we do)                          | Added | Total after |
| ---: | -: | -: | ----: | ----: | ------------: | ------------: | -------------------------------------------- | ----: | ----------: |
|    1 |  0 | 11 |     0 |     1 |             0 |             0 | `h[l]<h[r]`, `h[l]>=lmax` → set `lmax = 0`   |     0 |           0 |
|    2 |  1 | 11 |     1 |     1 |             0 |             0 | `h[l]>=h[r]` → set `rmax = 1`                |     0 |           0 |
|    3 |  1 | 10 |     1 |     2 |             0 |             1 | `h[l]<h[r]`, `h[l]>=lmax` → set `lmax = 1`   |     0 |           0 |
|    4 |  2 | 10 |     0 |     2 |             1 |             1 | `h[l]<h[r]`, `h[l]<lmax` → add `1 - 0 = 1`   |     1 |           1 |
|    5 |  3 | 10 |     2 |     2 |             1 |             1 | `h[l]>=h[r]` → set `rmax = 2`                |     0 |           1 |
|    6 |  3 |  9 |     2 |     1 |             1 |             2 | `h[l]>=h[r]` → `h[r]<rmax` → add `2 - 1 = 1` |     1 |           2 |
|    7 |  3 |  8 |     2 |     2 |             1 |             2 | `h[l]>=h[r]` → set `rmax = 2` (no change)    |     0 |           2 |
|    8 |  3 |  7 |     2 |     3 |             1 |             2 | `h[l]<h[r]`, `h[l]>=lmax` → set `lmax = 2`   |     0 |           2 |
|    9 |  4 |  7 |     1 |     3 |             2 |             2 | `h[l]<h[r]`, `h[l]<lmax` → add `2 - 1 = 1`   |     1 |           3 |
|   10 |  5 |  7 |     0 |     3 |             2 |             2 | `h[l]<h[r]`, `h[l]<lmax` → add `2 - 0 = 2`   |     2 |           5 |
|   11 |  6 |  7 |     1 |     3 |             2 |             2 | `h[l]<h[r]`, `h[l]<lmax` → add `2 - 1 = 1`   |     1 |           6 |
