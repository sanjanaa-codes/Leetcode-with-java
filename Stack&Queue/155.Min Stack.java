1. Brute Force (scan for min)

Idea: Store elements in a stack/ArrayList. To get min, scan all elements.
Edge case: Multiple equal minimums.

class MinStack {
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int v : stack) min = Math.min(min, v);
        return min;
    }
}

Dry-run (push -2, push 0, push -3, getMin, pop, top, getMin)

| Operation | Stack      | top() | getMin() |
| --------- | ---------- | ----- | -------- |
| push(-2)  | \[-2]      | -2    | -2       |
| push(0)   | \[-2,0]    | 0     | -2       |
| push(-3)  | \[-2,0,-3] | -3    | -3       |
| getMin()  | \[-2,0,-3] | -3    | **-3**   |
| pop()     | \[-2,0]    | 0     | -2       |
| top()     | \[-2,0]    | **0** | -2       |
| getMin()  | \[-2,0]    | 0     | **-2**   |

Complexity

push: O(1)
pop: O(1)
top: O(1)
getMin: O(n) — scans stack

Space: O(n)

Notes
Simple to implement but getMin() is expensive. Not good for big testcases.
_____________________________________________________________________________________________________________
2. Better (Two Stacks)

Idea: Maintain stack for values and minStack for current mins. Push to minStack only if ≤ current min.
Edge case: Duplicate mins must be tracked correctly.

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

| Operation | Main Stack    | Min Stack   | getMin() |
| --------: | ------------- | ----------- | -------: |
|  push(-2) | \[-2]         | \[-2]       |       -2 |
|   push(0) | \[-2, 0]      | \[-2]       |       -2 |
|  push(-3) | \[-2, 0, -3]  | \[-2, -3]   |       -3 |
|  getMin() | \[-2,0,-3]    | \[-2,-3]    |   **-3** |
|     pop() | \[-2,0]       | \[-2]       |       -2 |
|     top() | \[-2,0]       | \[-2]       |    **0** |
|  getMin() | \[-2,0]       | \[-2]       |   **-2** |
|  push(-2) | \[-2,0,-2]    | \[-2, -2]   |       -2 |
|  push(-2) | \[-2,0,-2,-2] | \[-2,-2,-2] |       -2 |
|  getMin() | ...           | ...         |   **-2** |
|     pop() | \[-2,0,-2]    | \[-2,-2]    |       -2 |
|  getMin() | \[-2,0,-2]    | \[-2,-2]    |   **-2** |

Complexity

push: O(1)
pop: O(1)
top: O(1)
getMin: O(1)

Space: O(n) (worst-case minStack stores all elements)

Notes
Very common interview solution. Handles duplicates of min correctly using <=.
_____________________________________________________________________________________________________________
Optimal — One Stack of Pairs (value, minSoFar)

class MinStack {
    private Stack<int[]> stack; // each int[] = {value, minSoFar}

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currMin = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, currMin});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

| Operation | Stack (pairs: (val,minSoFar)) | top() | getMin() |
| --------: | ----------------------------- | ----: | -------: |
|  push(-2) | \[(-2,-2)]                    |    -2 |       -2 |
|   push(0) | \[(-2,-2),(0,-2)]             |     0 |       -2 |
|  push(-3) | \[(-2,-2),(0,-2),(-3,-3)]     |    -3 |       -3 |
|  getMin() | ...                           |    -3 |   **-3** |
|     pop() | \[(-2,-2),(0,-2)]             |     0 |       -2 |
|     top() | ...                           | **0** |       -2 |
|  getMin() | ...                           |     0 |   **-2** |
|  push(-2) | \[(-2,-2),(0,-2),(-2,-2)]     |    -2 |       -2 |
|  push(-2) | \[...,(-2,-2),(-2,-2)]        |    -2 |       -2 |
|  getMin() | ...                           |    -2 |   **-2** |
|     pop() | ...                           |    -2 |       -2 |
|  getMin() | ...                           |    -2 |   **-2** |


Complexity
  
All ops push, pop, top, getMin are O(1)
Space: O(n) (stores pair per element but single stack)

Notes
Cleanest for MinStack: O(1) all operations + no separate min stack duplication.

