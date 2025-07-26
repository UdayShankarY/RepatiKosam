logic : 

    START balancedStringSplit(s)
    |
    v
    [Initialize Counters:]
    |- L_count = 0  // Count of 'L' characters
    |- R_count = 0  // Count of 'R' characters
    |- result = 0   // Total balanced substrings
    |
    v
    [Scan Each Character:]
    |- for i = 0 to s.length-1:
    |     if s[i] == 'L':
    |         L_count++
    |     else:
    |         R_count++
    |
    |     [Check Balance:]
    |     if L_count == R_count:
    |         result++           // Found a balanced substring
    |         L_count = R_count = 0  // Reset for next substring
    |
    v
    [Return Result:]
    |- return result
    END


Time & Space Complexity
Time: O(N) → Single pass through the string
Space: O(1) → Constant extra space used


1221. Split a String in Balanced Strings

Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.

 

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
 

Constraints:

2 <= s.length <= 1000
s[i] is either 'L' or 'R'.
s is a balanced string.

code:

    class Solution {
        public int balancedStringSplit(String s) {
            int L_count = 0;
            int R_count = 0;
            int result = 0;
            for(int i =0;i<s.length();i++){
                if(s.charAt(i) == 'L'){
                    L_count++;
                }
                else{
                    R_count++;
                }
                if(L_count == R_count){
                    result++;
                    L_count = R_count = 0;
                }
            }
            return result;
        }
    }