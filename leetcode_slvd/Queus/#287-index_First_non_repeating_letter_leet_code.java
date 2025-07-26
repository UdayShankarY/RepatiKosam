387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

    Input: s = "leetcode"

    Output: 0

    Explanation:

    The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

    Input: s = "loveleetcode"

    Output: 2

    Example 3:

    Input: s = "aabb"

    Output: -1

 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters



code : 

using Queue

    class Solution {
        public int firstUniqChar(String s) {
            Queue<Character> q = new LinkedList<>();
            int freq[] = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                freq[ch - 'a']++;       // Increment only once
                q.add(ch);

                // Remove repeated characters from front
                while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                    q.remove();
                }
            }

            if (q.isEmpty()) {
                return -1;
            } else {
                return s.indexOf(q.peek());
            }
        }
    }


without using Queue 

    class Solution {
        public int firstUniqChar(String s) {
            int[] freq = new int[26];

            // Count frequency of each character
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            // Find the first character with frequency 1
            for (int i = 0; i < s.length(); i++) {
                if (freq[s.charAt(i) - 'a'] == 1) {
                    return i;  // Index of first non-repeating character
                }
            }

            return -1;  // No non-repeating character
        }
    }
