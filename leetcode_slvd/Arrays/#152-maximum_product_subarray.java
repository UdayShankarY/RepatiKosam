logic : 

    +---------------------------------------------------------------------+
    |               MAXIMUM PRODUCT SUBARRAY CHEAT SHEET                  |
    +---------------------------------------------------------------------+
    |                                                                     |
    |   +-------------------------------------------------------------+   |
    |   |                    Initialization                           |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |  maxi = nums[0], mini = nums[0], ans = nums[0]              |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                    For Loop (i=1 to n-1)                    |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                    Check for Negative                       |   |
    |   |                    if (nums[i] < 0) {                       |   |
    |   |                        swap(maxi, mini);                    |   |
    |   |                    }                                        |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                    Update Products                          |   |
    |   |   mini = min(mini*nums[i], nums[i])                         |   |
    |   |   maxi = max(maxi*nums[i], nums[i])                         |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                    Update Answer                            |   |
    |   |   ans = max(ans, maxi);                                     |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                    return ans;                              |   |
    |   +-------------------------------------------------------------+   |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        KEY VARIABLES                               |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  maxi = Maximum product ending at current index                    |
    |  mini = Minimum product ending at current index                    |
    |  ans  = Global maximum product found                               |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        EXAMPLE CASE                               |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  nums = [2,3,-2,4]                                                  |
    |  i=1: maxi=6, mini=3, ans=6                                         |
    |  i=2: swap→ maxi=-2, mini=6 → maxi=-2, mini=-12, ans=6              |
    |  i=3: maxi=4, mini=-48, ans=6                                       |
    |  Final answer: 6                                                    |
    |                                                                     |
    +---------------------------------------------------------------------+
    |  Time Complexity: O(n)  Space Complexity: O(1)                     |
    +---------------------------------------------------------------------+


152. Maximum Product Subarray

Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

Example 2:

    Input: nums = [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
    

Constraints:

    1 <= nums.length <= 2 * 104
    -10 <= nums[i] <= 10
    The product of any subarray of nums is guaranteed to fit in a 32-bit integer


code : 

    class Solution {
        public int maxProduct(int[] nums) {
            int maxi = nums[0];
            int mini = nums[0];
            int ans = nums[0];

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] < 0) {
            int temp = maxi;
            maxi = mini;
            mini = temp;
        }
        
        maxi = Math.max(nums[i], maxi * nums[i]);
        mini = Math.min(nums[i], mini * nums[i]);

        ans = Math.max(ans, maxi);
    }
    return ans;
        }
    }


explaination :

 same as the max sum subarray but with diffrent formulas
 min and max are used to swap 

Keep track of both:

maxi → Maximum product so far

mini → Minimum product so far

Why?
Because multiplying by a negative number can:

Turn a max into a min

Or a min into a max

So we need both values at every step.


Algorithm Steps:
    Initialize:
        maxi = nums[0];
        mini = nums[0];
        ans = nums[0];
    Loop from index 1 to end:   
        If nums[i] < 0, swap maxi and mini
            Update:
                maxi = max(nums[i], maxi * nums[i])
                mini = min(nums[i], mini * nums[i])
                Update overall answer:
                ans = max(ans, maxi)
                Return ans

🔁 Example:
    Input: nums = [2, 3, -2, 4]
    Output: 6
    (Subarray [2, 3] gives max product)

Time Complexity:
    O(n) — one pass through the array

Space Complexity:
    O(1) — constant extra variables




dry run : 

    Before the loop:
        maxi = nums[0] = 2  
        mini = nums[0] = 2  
        ans = nums[0] = 2
    Loop Begins
        🔸 i = 1 → nums[1] = 3
        nums[i] = 3 (positive, no swap)
    
        maxi = max(3, 2 * 3) = max(3, 6) = 6

        mini = min(3, 2 * 3) = min(3, 6) = 3

        ans = max(2, 6) = 6

    📌 Current state:

        maxi = 6, mini = 3, ans = 6
        🔸 i = 2 → nums[2] = -2
        nums[i] < 0 → swap maxi and mini

        Now maxi = 3, mini = 6

        maxi = max(-2, 3 * -2) = max(-2, -6) = -2

        mini = min(-2, 6 * -2) = min(-2, -12) = -12

        ans = max(6, -2) = 6

    📌 Current state:

        maxi = -2, mini = -12, ans = 6
        🔸 i = 3 → nums[3] = 4
        nums[i] = 4 (positive, no swap)

        maxi = max(4, -2 * 4) = max(4, -8) = 4

        mini = min(4, -12 * 4) = min(4, -48) = -48

        ans = max(6, 4) = 6

    📌 Current state:

        maxi = 4, mini = -48, ans = 6

    ✅ Loop Ends
    Final result:

        return ans; // → 6



