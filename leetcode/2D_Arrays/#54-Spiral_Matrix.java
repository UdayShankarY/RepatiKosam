54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100



code : 

    import java.util.*;

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();

            int startRow = 0;
            int startCol = 0;
            int endRow = matrix.length-1;
            int endCol = matrix[0].length-1;

            while(endCol >= startCol && endRow >= startRow){

            // top row only (your code)
            for (int i = startCol; i <= endCol; i++) {
                list.add(matrix[startRow][i]);
            }
            // right
            for (int i = startRow+1; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }
            //bottom
            for (int i = endCol-1; i >=startCol; i--) {
                if(startRow == endRow){
                    break;
                }
                list.add(matrix[endRow][i]);
            }
            //left
            for(int i = endRow-1;i>=startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                list.add(matrix[i][startCol]);
            }
            endRow--;
            endCol--;
            startCol++;
            startRow++;
            }

            return list;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

            List<Integer> result = sol.spiralOrder(matrix);
            System.out.println("Spiral Order Top Row: " + result);
        }
    }
