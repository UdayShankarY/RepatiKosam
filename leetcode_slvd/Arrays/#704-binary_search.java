logic : 

    +---------------------------------------------------------------------+
    |                    BINARY SEARCH CHEAT SHEET                        |
    +---------------------------------------------------------------------+
    |                                                                     |
    |   +-------------------------------------------------------------+   |
    |   |                     Initial Setup                           |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |              +------------------------------------------+          |
    |              | low = 0, high = nums.length - 1          |          |
    |              +------------------------------------------+          |
    |                                |                                    |
    |                                v                                    |
    |                        +------------------+                        |
    |                        | while (low ≤ high)|                        |
    |                        +------------------+                        |
    |                                |                                    |
    |                                v                                    |
    |              +------------------------------------------+          |
    |              | mid = low + (high - low) / 2             |          |
    |              +------------------------------------------+          |
    |                                |                                    |
    |                                v                                    |
    |           +--------------------------------------------+           |
    |           |              Check Conditions              |           |
    |           +--------------------------------------------+           |
    |               |                 |                 |                |
    |               v                 v                 v                |
    |   +------------------+ +------------------+ +------------------+   |
    |   | if (nums[mid] == | | else if (target  | | else (target <   |   |
    |   | target) → return | | > nums[mid]) →   | | nums[mid]) →     |   |
    |   | mid              | | low = mid + 1    | | high = mid - 1   |   |
    |   +------------------+ +------------------+ +------------------+   |
    |                                |                                    |
    |                                v                                    |
    |                        +------------------+                        |
    |                        |   return -1       |                        |
    |                        +------------------+                        |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        KEY VARIABLES                                |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  low  = left boundary of search space                               |
    |  high = right boundary of search space                              |
    |  mid  = middle index being checked                                  |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        EXAMPLE CASES                                |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  Found:     [1, 3, 5, 7, 9], target = 5 → Returns 2                 |
    |  Not Found: [2, 4, 6],      target = 5 → Returns -1                |
    |  Edge Case: [],               target = 1 → Returns -1              |
    |                                                                     |
    +---------------------------------------------------------------------+




704. Binary Search

    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.

Example 1:

    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4
Example 2:

    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1
    
Constraints:

    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.



code : 

    class Solution {
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length-1;
            int mid;
            while(low<=high){
            mid = (low+high)/2;
                if(target == nums[mid]){
                    return mid;
                }
                else if(target > nums[mid]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }

            return -1;
        }
    }


explaination : 

my : 

    given array nums and target find until target found (mid == target)
    set low = 0 and high as nums.length-1
    run a loop while(low <= high)
    here low,high,mid stores the indexes
    check if(target == mid) then return mid
    check if (target > nums[mid]) then  low = mid + 1 - since it is sorted array
    check else(target < nums[mid]) then high = mid - 1
    if all  the above condition fails means the target not found in the array then return -1



chat gpt : 

    Given a sorted array nums[] and a target value, we need to find the index of the target using Binary Search.

    Steps:
    Initialize pointers:

    low = 0 (start of the array).

    high = nums.length - 1 (end of the array).

    Loop until target is found or range is exhausted:

    Run a loop while (low <= high) — the loop continues as long as there are elements left to check between low and high.

    Calculate middle index:

    mid = (low + high) / 2 — calculate the middle index.

    Check if target is found:

    If target == nums[mid], return the index mid (target found).

    If target is greater than middle element:

    If target > nums[mid], set low = mid + 1. This is because the target must be in the right half of the array (since the array is sorted).

    If target is less than middle element:

    If target < nums[mid], set high = mid - 1. This is because the target must be in the left half of the array.

    Return -1:

    If the loop ends without finding the target, return -1 (target is not present in the array).


✅ Refined Explanation Summary:
    Start with low = 0 and high = nums.length - 1.

    Loop while low <= high:

    Calculate mid = (low + high) / 2.

    If target == nums[mid], return mid.

    If target > nums[mid], move the low pointer to the right (low = mid + 1).

    If target < nums[mid], move the high pointer to the left (high = mid - 1).

    If target is not found, return -1.

    time complexity : O(log n) complexity log n comes when yourading iterations i = i/2 or i = i*2
    space complexity : O(1) because we are not using any od the data    structures


dry run :

    Example 1:
        nums = [2, 4, 6, 8, 10]
        target = 8
        Start: low = 0, high = 4

        mid = (0 + 4) / 2 = 2 → nums[2] = 6

        target > nums[mid], so move right → low = 3

        mid = (3 + 4) / 2 = 3 → nums[3] = 8

        target == nums[mid], so return 3

    Example 2:
        nums = [2, 4, 6, 8, 10]
        target = 1
        Start: low = 0, high = 4

        mid = (0 + 4) / 2 = 2 → nums[2] = 6

        target < nums[mid], so move left → high = 1

        mid = (0 + 1) / 2 = 0 → nums[0] = 2

        target < nums[mid], so move left again → high = -1

        Now low > high, so return -1

        ❌ Target not found

