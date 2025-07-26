logic : 

    +---------------------------------------------------------------------+
    |                TRAPPING RAIN WATER CHEAT SHEET                      |
    +---------------------------------------------------------------------+
    |                                                                     |
    |   +-------------------------------------------------------------+   |
    |   |                     Initial Setup                           |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   | Create arrays:                                             |   |
    |   | lmb[] - Left Max Boundaries                                |   |
    |   | rmb[] - Right Max Boundaries                               |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   | Fill Left Max Boundaries:                                  |   |
    |   | lmb[0] = height[0]                                         |   |
    |   | for (i=1 to n-1):                                          |   |
    |   |    lmb[i] = max(height[i], lmb[i-1])                       |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   | Fill Right Max Boundaries:                                 |   |
    |   | rmb[n-1] = height[n-1]                                     |   |
    |   | for (i=n-2 downto 0):                                      |   |
    |   |    rmb[i] = max(height[i], rmb[i+1])                       |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   | Calculate Trapped Water:                                   |   |
    |   | total = 0                                                  |   |
    |   | for (i=0 to n-1):                                          |   |
    |   |    water = min(lmb[i], rmb[i]) - height[i]                 |   |
    |   |    total += max(water, 0)                                  |   |
    |   +-------------------------------------------------------------+   |
    |                                |                                    |
    |                                v                                    |
    |   +-------------------------------------------------------------+   |
    |   | return total; // Total trapped water                       |   |
    |   +-------------------------------------------------------------+   |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        KEY VARIABLES                                |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  lmb[]    = Left maximum boundaries (prefix max)                    |
    |  rmb[]    = Right maximum boundaries (suffix max)                   |
    |  height[] = Original elevation map                                  |
    |  water    = Water trapped at current index                         |
    |  total    = Cumulative trapped water                               |
    |                                                                     |
    +---------------------------------------------------------------------+
    |                        EXAMPLE CASE                                |
    +---------------------------------------------------------------------+
    |                                                                     |
    |  height = [0,1,0,2,1,0,1,3,2,1,2,1]                                |
    |  lmb    = [0,1,1,2,2,2,2,3,3,3,3,3]                                |
    |  rmb    = [3,3,3,3,3,3,3,2,2,2,1,1]                                |
    |  Water at i=4: min(2,3)-1 = 1 unit                                 |
    |  Total trapped water = 6 units                                     |
    |                                                                     |
    +---------------------------------------------------------------------+
    |  Time Complexity: O(n)     Space Complexity: O(n)                   |
    +---------------------------------------------------------------------+




42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

code : 
    class Solution {
        public int trap(int[] height) {
            int LHB[] = new int[height.length];
            int RHB[] = new int[height.length];
            LHB[0] = height[0];
            for(int i = 1;i<height.length;i++){
                LHB[i] = Math.max(LHB[i-1],height[i]);
            }
            RHB[height.length-1] = height[height.length-1];
            for(int i = height.length-2;i>=0;i--){
                RHB[i] = Math.max(RHB[i+1],height[i]);
            }

            int trapped_water = 0;
            for(int i = 0;i<height.length;i++){
                int water = Math.min(LHB[i],RHB[i]);
                trapped_water += water - height[i]; 
            }
            return trapped_water;
        }
    }


explanation : 

my :  
    for calculating the boundaraies declare a arrays
    int lmb[] = new int[height.length]
    int rmb[] = new int[height.length]

    Initialize - lmb[0] = height[0] 
    for-loop from i = 1 to height.length
    lmb = max(height[i],lmb[i-1])
    end for-loop

    intialize - rmb[height.length-1] = height[height.length-1]
    for-loop from i = height.length-2 to i>=0
    rmb = max(height[i],rmb[i+1])
    
    why height.length-1 -> because index start from 0 then to make them equal we use height.length-1
    why height.length-2 -> because we have already inialized from height.length-1 so thats way

    we have 2 main formulas
        water,trrapped_water
        here water = min(left max boundry , right max boundry)
        trapped_water += water - height
        at last return total trapped_water


time complexity  :  All three loops are separate and each runs once ⇒
                    T(n) = O(n) + O(n) + O(n) = O(n)


Space Complexity :
                    LHB[] → O(n)
                    RHB[] → O(n)

Final Answer     :
                    Time Complexity: O(n)
                    Space Complexity: O(n)


gpt : 

        Create 2 arrays:

    lmb[] → stores Left Max Boundaries

    rmb[] → stores Right Max Boundaries

    Fill Left Max Boundary (lmb):

    lmb[0] = height[0];
    for (int i = 1; i < height.length; i++) {
        lmb[i] = Math.max(height[i], lmb[i - 1]);
    }
    Fill Right Max Boundary (rmb):

    rmb[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
        rmb[i] = Math.max(height[i], rmb[i + 1]);
    }
    Main Formula:

    water = min(lmb[i], rmb[i])

    trapped_water = water - height[i]

    Add all trapped_water to total_water_trapped

    Return the total:

    return total_water_trapped;

