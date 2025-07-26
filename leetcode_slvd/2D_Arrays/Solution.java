import java.util.*;

class Solution {
    public int maxPower(String s) {
        int max = Integer.MIN_VALUE;
        int len = 1;
        char prev = s.charAt(0);
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == prev){
                len++;
            }
            else{
                prev = s.charAt(i);
                len = 1;
            }
                max = Math.max(len,max);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abbcccddddeeeeedcba";
        int result = sol.maxPower(s);
        System.out.println("Max Power: " + result);  // Output: 5
    }
}
