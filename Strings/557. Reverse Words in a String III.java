class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String i : arr) {
            sb.append(new StringBuilder(i).reverse()).append(" ");

        }
        return sb.toString().trim();

    }
}


| Step                                | Time Complexity | Space Complexity |
|-------------------------------------|-----------------|------------------|
| s.split("\\s+")                     | O(n)            | O(n)             |
| Reversing each word                 | O(n)            | O(n) (temp)      |
| Appending to StringBuilder          | O(n)            | O(1)             |
| Final StringBuilder result          | -               | O(n)             |
| **Total**                           | **O(n)**        | **O(n)**         |


✅ Final Answer:
Time Complexity: O(n)
Space Complexity: O(n)
