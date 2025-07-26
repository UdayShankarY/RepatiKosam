logic : 
    +---------------------------------------------------------------------+
    |                  DUPLICATE DETECTION CHEAT SHEET                   |
    +---------------------------------------------------------------------+
    |                                                                     |
    |   +-------------------------------------------------------------+   |
    |   |                      Initial Step                           |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                   Sort the Array First                      |   |
    |   |                   Arrays.sort(nums);                        |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                 Check for Duplicates                        |   |
    |   |                 for (i=0 to nums.length-1):                 |   |
    |   |                    +---------------------+                  |   |
    |   |                    | if (i < nums.length-1 &&               |   |
    |   |                    |     nums[i] == nums[i+1]):             |   |
    |   |                    |   return true       |                  |   |
    |   |                    +---------------------+                  |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                 return false; // No duplicates found        |   |
    |   +-------------------------------------------------------------+   |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        KEY POINTS                                  |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  1. Sorting brings duplicates together                              |
    |  2. Check current vs next element (safe with i < nums.length-1)    |
    |  3. Loop runs full length but condition protects bounds             |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        EXAMPLE CASES                                |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  Input: [3, 1, 2, 1] → Sorted: [1, 1, 2, 3] → Returns true (1,1)    |
    |  Input: [5, 2, 7, 3] → Sorted: [2, 3, 5, 7] → Returns false         |
    |  Input: [1] → Returns false (single element)                        |
    |                                                                     |
    +---------------------------------------------------------------------+
    |  Time Complexity: O(n log n)  Space Complexity: O(1)                |
    +---------------------------------------------------------------------+



217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109


code : 
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i = 0;i<nums.length-1;i++){
                if(nums[i] == nums[i+1]){
                    return true;
                }
            }
            return false;
        }
    }
    
can be solve using hasmap for more effitiency

explanation : 
    first sort the array and then check 
    for loop form i = 0 to nums.length-1
        if(nums[i] == nums[i+1]) 
            then return true
        
        return false at last

        or

    if you start from i = 1
    for loop form i = 1 to nums.length
        if(nums[i] == nums[i-1]) 
            then return true
        
        return false at last
        

time complexity : 
    sorting : O(n log n)
    loop : O(n)
    final : O(n log n)
space complexity: O(1)
