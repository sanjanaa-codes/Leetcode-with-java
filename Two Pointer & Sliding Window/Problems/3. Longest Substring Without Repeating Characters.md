1. Brute Force ✅ 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}

🕒 Time Complexity: O(n²)
📦 Space Complexity: O(n)

🔁 Example Dry Run (s = "abcabcbb")

| i | j | s\[j] | set       | maxLength |
| - | - | ----- | --------- | --------- |
| 0 | 0 | 'a'   | {a}       | 1         |
| 0 | 1 | 'b'   | {a,b}     | 2         |
| 0 | 2 | 'c'   | {a,b,c}   | 3         |
| 0 | 3 | 'a'   | duplicate | break     |

______________________________________________________________________________________________________________________
  
🔧 Optimized Sliding Window with HashSet

class Solution {
    public int lengthOfLongestSubstring(String str) {
        if (str.length() == 0)
            return 0;

        int maxans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int l = 0;

        for (int r = 0; r < str.length(); r++) {
            if (set.contains(str.charAt(r))) {
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }

        return maxans;
    }
}

🧠 Concept Used:
We maintain a sliding window from index l to r.
The window contains unique characters only.
If a duplicate is found at r, we shrink the window from the left (l) until the duplicate is removed.
maxans = Math.max(maxans, r - l + 1) gives the maximum length of the window seen so far.

🔢 Key Formula: Length of window = r - l + 1

| Step | l | r | str\[r] | Action                     | Set       | maxans |
| ---- | - | - | ------- | -------------------------- | --------- | ------ |
| 1    | 0 | 0 | 'a'     | add                        | {a}       | 1      |
| 2    | 0 | 1 | 'b'     | add                        | {a, b}    | 2      |
| 3    | 0 | 2 | 'c'     | add                        | {a, b, c} | 3      |
| 4    | 0 | 3 | 'a'     | duplicate → remove a (l=1) | {b, c, a} | 3      |
| 5    | 1 | 4 | 'b'     | duplicate → remove b (l=2) | {c, a, b} | 3      |
| 6    | 2 | 5 | 'c'     | duplicate → remove c (l=3) | {a, b, c} | 3      |
| 7    | 3 | 6 | 'b'     | duplicate → remove b (l=5) | {c, b}    | 3      |
| 8    | 5 | 7 | 'b'     | duplicate → remove b (l=6) | {b}       | 3      |

⏱ Time Complexity: O(n)
Each character is inserted and removed from the set at most once.

📦 Space Complexity: O(n)
Set stores up to n characters in worst case.

______________________________________________________________________________________________________________________
  
🔹 Idea:
Use a HashMap to store the last seen index of each character.

When a duplicate is found, jump the left pointer to max(lastIndex + 1, left) to ensure all characters in the current window are unique.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                // Only move left forward
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

🧪 Dry Run Example:
s = "abcabcbb"

| Step | Left | Right | Char | Map             | MaxLen |
| ---- | ---- | ----- | ---- | --------------- | ------ |
| 0    | 0    | 0     | a    | {a:0}           | 1      |
| 1    | 0    | 1     | b    | {a:0, b:1}      | 2      |
| 2    | 0    | 2     | c    | {a:0, b:1, c:2} | 3      |
| 3    | 0→1  | 3     | a    | {a:3, b:1, c:2} | 3      |
| 4    | 1→2  | 4     | b    | {a:3, b:4, c:2} | 3      |
| 5    | 2→3  | 5     | c    | {a:3, b:4, c:5} | 3      |
| 6    | 3→5  | 6     | b    | {a:3, b:6, c:5} | 3      |
| 7    | 5→6  | 7     | b    | {a:3, b:7, c:5} | 3      |

✅ Final Answer = 3
Substring = "abc" or "bca" or "cab" → all length 3


| Approach         | Time  | Space | Notes                              |
| ---------------- | ----- | ----- | ---------------------------------- |
| Brute Force      | O(n²) | O(n)  | Try all substrings                 |
| Better (HashSet) | O(n)  | O(n)  | Sliding window + HashSet           |
| ✅ Optimal       | O(n)  | O(n)  | Sliding window + HashMap with jump |
