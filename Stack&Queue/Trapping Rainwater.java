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

