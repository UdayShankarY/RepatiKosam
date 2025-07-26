logic : 

┌───────────────────────────────────────────────────────────────┐
│                 KADANEs ALGORITHM CHEAT SHEET                │
├───────────────────────────────────────────────────────────────┤
│                                                               │
│  ┌─────────────────────────────────────────────────────────┐  │
│  │                     Initial Check                       │  │
│  └─────────────────────────────────────────────────────────┘  │
│                       │                                       │
│                       ▼                                       │ 
│          ┌─────────────────────┐                              │
│          │ Are all elements    │ No                           │
│          │ negative?           ├──────────┐                   │
│          └─────────────────────┘          │                   │
│                       │                   │                   │
│                      Yes                  │                   │
│                       │                   │                   │
│                       ▼                   ▼                   │
│  ┌───────────────────────────┐  ┌─────────────────────────┐   │
│  │ Return maximum           │   │ Initialize:             │   │
│  │ negative value           │   │ cs = 0, ms = - infinity │   │
│  └───────────────────────────┘  └─────────────────────────┘   │
│                                         │                     │
│                                         ▼                     │
│                                ┌───────────────────┐          │
│                                │ For each element: │          │
│                                └───────────────────┘          │
│                                         │                     │
│                                         ▼                     │
│                          ┌────────────────────────────┐       │
│                          │ cs = cs + nums[i]          │       │
│                          └────────────────────────────┘       │
│                                         │                     │
│                                         ▼                     │
│                          ┌────────────────────────────┐       │
│                          │ if (cs < 0) cs = 0         │       │
│                          └────────────────────────────┘       │
│                                         │                     │
│                                         ▼                     │
│                          ┌────────────────────────────┐       │
│                          │ ms = max(ms, cs)           │       │
│                          └────────────────────────────┘       │
│                                         │                     │
│                                         ▼                     │
│                                ┌───────────────────┐          │
│                                │   Return ms       │          │
│                                └───────────────────┘          │
│                                                               │
├───────────────────────────────────────────────────────────────┤
│                        KEY VARIABLES                          │
├───────────────────────────────────────────────────────────────┤
│                                                               │
│  cs = current_sum (running sum of current subarray)           │
│  ms = max_sum (maximum sum found so far)                      │
│                                                               │
├───────────────────────────────────────────────────────────────┤
│                        EXAMPLE CASES                          │
├───────────────────────────────────────────────────────────────┤
│                                                               │
│  All negative: [-2, -5, -7] → Return -2                       │
│  Mixed: [2, -3, 4, -1, 2] → Return 5 (from [4, -1, 2])        │
│  All positive: [1, 2, 3] → Return 6                           │
│                                                               │
└───────────────────────────────────────────────────────────────┘



53. Maximum Subarray

Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
 
Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle



code : 

class Solution {
public boolean isallnegative(int nums[]){
    for(int i =0;i<nums.length;i++){
    if(nums[i] > 0){
            return false;
        }
}
return true;
}

    public int maxSubArray(int[] nums) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        if(isallnegative(nums) == true){
            int maxneg = nums[0];
            for(int i = 0;i<nums.length;i++){
                if(nums[i] > maxneg){
                    maxneg = nums[i];
                }
            } 
            return maxneg;
        }
     for(int i = 0;i<nums.length;i++){
            cs = cs + nums[i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(ms,cs);
     }   
     return ms;
    }
}



 
leet-code code: 

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum = Math.max(n, n + sum);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}





Explanation :
my :
using kadanes algo 
there is a internal function isallnegative that returns true/false based on if all the numbers in the array are negative or positive 
if all negative - false else true
if all the element in the array are negative then max summ of subarray is the largest negative value [-2,-5,-7,-8,-6] -> largest is -2 
if all elements in the array are not negative then use kadanes algo

take varibles max_sum -> ms and current_sum-> cs

cs -> cs + nums[i]
if (cs<0) then cs = 0
ms = Math.max(ms,cs);
at last return max_sum -> ms




chat gpt : 

(Kadanes Algorithm Based)
I'm using Kadane's Algorithm to find the maximum sum subarray.

🔹 Internal Function: isallnegative(int nums[])
This function returns:

true → if all elements are negative

false → if there is at least one positive number

🔹 If all elements are negative:
Then the maximum subarray sum is just the largest negative number.

Example:
[-2, -5, -7, -8, -6] → max = -2

🔹 If array has at least one positive:
Then I apply Kadanes Algorithm.

🔹 Variables Used:
cs → current_sum

ms → max_sum

🔁 Loop Logic (Kadanes):
run a loop from i = 0 to nums.length
cs = cs + nums[i];
if (cs < 0) cs = 0;
ms = Math.max(ms, cs);

end loop 
🔚 Final Step:
Return ms → which holds the maximum subarray sum.

time complexity : O(n) -> because if all elements <0 then O(n) or if not then also O(n) 
Space complexity : O(1) -> beacuse No extra arrays or data structures. so O(1) constant time

🧮 Dry Run Table:

i	nums[i]	cs before	cs = cs + nums[i]	if cs < 0 → cs = 0	ms = max(ms, cs)
0	-2	        0	        -2	                0	                0
1	-3	        0	        -3	                0	                0
2	4	        0	         4	                4	                4
3	-1	        4	         3	                3	                4
4	-2	        3	         1	                1	                4
5	1	        1	         2	                2	                4
6	5	        2	         7	                7	                7 ✅
7	-3	        7	         4	                4	                7
 


nums = [-2,-3,4,-1,-2,1,5,-3]
cs  - 0,0,4,3,1,2,7,4
ms - 0,0,4,4,4,4,7,7-> 7 is the answer
