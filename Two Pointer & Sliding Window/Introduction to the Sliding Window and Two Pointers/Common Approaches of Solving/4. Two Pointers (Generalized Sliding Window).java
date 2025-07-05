Description:
Both pointers move independently to find subarrays/substrings that meet more complex or custom criteria (e.g., minimum window substring, longest substring without repeating characters).

public int lengthOfLongestSubstring(String s) {
    int n = s.length(), left = 0, maxLen = 0;
    Set<Character> set = new HashSet<>();

    for (int right = 0; right < n; right++) {
        while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left++)); // move left to remove duplicates
        }
        set.add(s.charAt(right)); // include current character
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}

🧠 Concept: Two Pointers (Left & Right)
right expands the window (move forward)
left shrinks the window to remove duplicates
set stores unique characters in the current window

🧪 Example:
Let s = "abcabcbb"

Start: left = 0, right = 0, set = {}, maxLen = 0

Steps:

'a' → add to set → maxLen = 1

'b' → add → maxLen = 2

'c' → add → maxLen = 3

'a' → duplicate! Remove 'a' at left, then add → still length 3

'b' → duplicate! Remove 'b' at left, then add → still length 3

'c' → duplicate! Remove 'c' at left, then add → still length 3

'b' → duplicate! Remove 'b' at left, then add → still length 3

✅ Final Answer: maxLen = 3 (for "abc")

⏱ Time Complexity:
O(n) – Each character is visited at most twice (once by right, once by left)

📦 Space Complexity:
O(min(n, m))
n = length of string
m = size of character set (e.g., 26 for lowercase, 128 for ASCII)

💡 Real-World Use:
Used in many substring/subarray problems where uniqueness, frequency, or constraints need to be maintained dynamically.
Let me know if you'd like similar examples like:
Minimum Window Substring
Longest Substring with at most K distinct characters
etc.
