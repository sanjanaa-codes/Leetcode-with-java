Here are some **easy LeetCode Java questions** that require **only basic programming, no complex thinking or data structures**, and can be solved with **simple loops, conditionals, arrays, or math**:

---

### ✅ **List of Beginner-Friendly LeetCode Java Problems**

These questions mostly use:

* If-else
* Loops
* Arrays
* Basic math or string functions

---

### 📘 **1. 1480. Running Sum of 1D Array**

🧠 Just keep adding previous elements.

```java
public int[] runningSum(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
        nums[i] += nums[i - 1];
    }
    return nums;
}
```

---

### 📘 **2. 1672. Richest Customer Wealth**

🧠 Just sum each row in 2D array and track the max.

```java
public int maximumWealth(int[][] accounts) {
    int max = 0;
    for (int[] customer : accounts) {
        int sum = 0;
        for (int amount : customer) sum += amount;
        max = Math.max(max, sum);
    }
    return max;
}
```

---

### 📘 **3. 1. Two Sum**

🧠 Just use 2 for-loops (brute force) to find two numbers that add up to target.

```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target)
                return new int[] { i, j };
        }
    }
    return new int[] {};
}
```

---

### 📘 **4. 9. Palindrome Number**

🧠 Convert number to string and check if it's same reversed.

```java
public boolean isPalindrome(int x) {
    String s = Integer.toString(x);
    String rev = new StringBuilder(s).reverse().toString();
    return s.equals(rev);
}
```

---

### 📘 **5. 13. Roman to Integer**

🧠 Use `if-else` or `switch-case` to convert Roman numerals.
(No DS needed if you write direct if-else.)

---

### 📘 **6. 66. Plus One**

🧠 Add 1 to the last digit. If it's 9, handle carry.

```java
public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        digits[i] = 0;
    }
    int[] res = new int[digits.length + 1];
    res[0] = 1;
    return res;
}
```

---

### 📘 **7. 283. Move Zeroes**

🧠 Move all zeroes to the end using a simple loop.

```java
public void moveZeroes(int[] nums) {
    int i = 0;
    for (int num : nums) {
        if (num != 0) nums[i++] = num;
    }
    while (i < nums.length) nums[i++] = 0;
}
```

---

### 📘 **8. 412. Fizz Buzz**

🧠 Classic logic problem using if-else and loop.

```java
public List<String> fizzBuzz(int n) {
    List<String> res = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        if (i % 15 == 0) res.add("FizzBuzz");
        else if (i % 3 == 0) res.add("Fizz");
        else if (i % 5 == 0) res.add("Buzz");
        else res.add(String.valueOf(i));
    }
    return res;
}
```

---

### 📘 **9. 1342. Number of Steps to Reduce a Number to Zero**

🧠 While number > 0, divide by 2 or subtract 1.

```java
public int numberOfSteps(int num) {
    int steps = 0;
    while (num > 0) {
        num = (num % 2 == 0) ? num / 2 : num - 1;
        steps++;
    }
    return steps;
}
```

---

### 📘 **10. 1108. Defanging an IP Address**

🧠 Replace "." with "\[.]" using simple string function.

```java
public String defangIPaddr(String address) {
    return address.replace(".", "[.]");
}
```

---

### Want More?

Let me know if you want more **simple practice questions** or questions based on **only strings**, **loops**, or **array tricks**.

Shall I create a **30-day plan** with just beginner Java LeetCode questions too?
