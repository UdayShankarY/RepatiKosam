logic : 

    +---------------------------------------------------------------------+
    |            SEARCH IN ROTATED SORTED ARRAY CHEAT SHEET               |
    +---------------------------------------------------------------------+
    |                                                                     |
    |   +-------------------------------------------------------------+   |
    |   |                    Initialization                           |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |  int low = 0, high = nums.length - 1;                       |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                    Binary Search Loop                       |   |
    |   |    while (low <= high) {                                    |   |
    |   |        int mid = (low + high) / 2;                          |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                    Three Main Cases                         |   |
    |   +-------------------------------------------------------------+   |
    |              |                            |                          |
    |              v                            v                          |
    |   +---------------------+    +------------------------------+       |
    |   | Case 1:             |    | Case 2: Left half sorted      |       |
    |   | nums[mid] == target |    | (nums[low] <= nums[mid])      |       |
    |   | → return mid        |    | if target in [low, mid]       |       |
    |   +---------------------+    | → high = mid - 1             |       |
    |                              | else → low = mid + 1         |       |
    |                              +------------------------------+       |
    |                                            |                        |
    |                                            v                        |
    |                              +------------------------------+       |
    |                              | Case 3: Right half sorted    |       |
    |                              | if target in [mid, high]     |       |
    |                              | → low = mid + 1             |       |
    |                              | else → high = mid - 1       |       |
    |                              +------------------------------+       |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   |                    return -1; // Not found                  |   |
    |   +-------------------------------------------------------------+   |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        KEY POINTS                                  |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  1. Works for arrays rotated at unknown pivot                      |
    |  2. First checks if mid is target                                  |
    |  3. Determines which half is sorted                                |
    |  4. Checks if target lies in sorted half                           |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        EXAMPLE                                     |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  nums = [4,5,6,7,0,1,2], target = 0                                |
    |  low=0, high=6 → mid=3 (7)                                         |
    |  Case 2: Left half [4,5,6,7] sorted but 0 not in range → right     |
    |  low=4, high=6 → mid=5 (1)                                         |
    |  Case 3: Right half [0,1,2] sorted and 0 in range → found at idx=4 |
    |                                                                     |
    +---------------------------------------------------------------------+
    |  Time Complexity: O(log n)  Space Complexity: O(1)                 |
    +---------------------------------------------------------------------+



33. Search in Rotated Sorted Array
    There is an integer array nums sorted in ascending order (with distinct values).
    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    You must write an algorithm with O(log n) runtime complexity.

 
Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
    Example 3:

    Input: nums = [1], target = 0
    Output: -1
 

Constraints:

    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104



code : 
    class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                return mid; // Found target
            }

            // Case 1: Left half is sorted
            else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1; // Search in left half
                } else {
                    low = mid + 1; // Search in right half
                }
            }

            // Case 2: Right half is sorted
            else {
                if (target >= nums[mid + 1] && target <= nums[high]) {
                    low = mid + 1; // Search in right half
                } else {
                    high = mid - 1; // Search in left half
                }
            }
        }

        return -1; // Target not found
    }
}


explanation : 
my : 
    same as the binary search 2 cases vary here 
    case 1: if target == nums[mid] is same

    Case 2: Left half is sorted
            else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1; // Search in left half
                } else {
                    low = mid + 1; // Search in right half
                }
            }

    Case 3: Right half is sorted
            else {
                if (target >= nums[mid + 1] && target <= nums[high]) {
                    low = mid + 1; // Search in right half
                } else {
                    high = mid - 1; // Search in left half
                }
            }

gpt : 
    Initialize:
    int low = 0, high = nums.length - 1;
    Binary Search Loop:

    while (low <= high) {
        int mid = (low + high) / 2;
    Three Main Cases:

    ✅ Case 1: If nums[mid] == target → return mid

    🔼 Case 2: If left half is sorted (nums[low] <= nums[mid])

    If target lies in this range → search left (high = mid - 1)

    Else → search right (low = mid + 1)

    🔽 Case 3: Else right half is sorted

    If target lies in this range → search right (low = mid + 1)

    Else → search left (high = mid - 1)

    ❌ If not found → return -1

Time Complexity: O(log n)
Space Complexity: O(1)



dry run : 
    
    🔍 Step-by-step Dry Run:
    Initial values:

    low = 0

    high = 6 (nums.length - 1)

    🔁 1st Iteration:
    mid = (0 + 6) / 2 = 3

    nums[mid] = 7

    Check:

    nums[low] <= nums[mid] → 4 <= 7 → ✅ Left half is sorted

    Is target 0 in left half [4, 5, 6, 7]? ❌ No
    → So search right: low = mid + 1 = 4

    🔁 2nd Iteration:
    low = 4, high = 6

    mid = (4 + 6) / 2 = 5

    nums[mid] = 1

    Check:

    nums[low] <= nums[mid] → 0 <= 1 → ✅ Left half is sorted

    Is target 0 in left half [0, 1]? ✅ Yes
    → So search left: high = mid - 1 = 4

    🔁 3rd Iteration:
    low = 4, high = 4

    mid = (4 + 4) / 2 = 4

    nums[mid] = 0

    Check:

    nums[mid] == target → ✅ Match found!
    → Return 4

    ✅ Final Output: 4

