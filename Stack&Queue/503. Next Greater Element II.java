class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int N=nums.length;
        int[] arr = new int[N];
        for(int i=2*N -1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%N]){
                stack.pop();
            }
            if(i<N){
                arr[i] = stack.isEmpty()? -1:stack.peek();
            }
            stack.push(nums[i%N]);
        }
        return arr;
    }
}

We process indices from 2N−1 → 0 (so that we simulate the circular array by visiting each element twice).
For each index:
  While top of stack ≤ current element → pop.
  If index is in original range (i < N), store the answer as either stack top or -1.
  Push current element.

🔹 Time Complexity

Outer loop runs 2N times.
Each element is pushed at most once and popped at most once from the stack.
So total operations = O(2N) ≈ O(N).
👉 Time Complexity = O(N)

🔹 Space Complexity

Stack: can hold at most N elements in worst case (strictly increasing array).
Result array: arr of size N.
Extra variables are constant.
👉 Space Complexity = O(N) (for stack + output array).
If we exclude output (which is required), auxiliary space = O(N).
