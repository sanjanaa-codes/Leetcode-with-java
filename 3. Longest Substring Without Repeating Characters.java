1. Brute Force 

✅ Code:

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
  
✅ 2. Better Approach – Sliding Window + HashSet
🔹 Idea:
Use a sliding window [left, right].
Use HashSet to maintain unique characters.
Slide window by removing from left when duplicate found.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}

⏱ Time Complexity: O(2n) ≈ O(n)
Each character is added and removed once.
📦 Space Complexity: O(n)

______________________________________________________________________________________________________________________
  
✅ 3. Optimal Approach – Sliding Window + HashMap (Index Jump)
  
🔹 Idea:
Store the last seen index of each character.
If duplicate found, jump left to max(lastIndex + 1, left)

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                // Jump left pointer only forward
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

🧪 Dry Run Example: s = "abcabcbb"

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

✅ Final Answer = 3 ("abc")

📌 Summary Table

| Approach    | Time  | Space | Notes                    |
| ----------- | ----- | ----- | ------------------------ |
| Brute Force | O(n²) | O(n)  | Try all substrings       |
| Better      | O(n)  | O(n)  | Sliding window + HashSet |
| **Optimal** | O(n)  | O(n)  | Sliding window + HashMap |
