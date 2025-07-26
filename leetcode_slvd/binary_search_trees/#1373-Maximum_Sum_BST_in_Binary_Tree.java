1373. Maximum Sum BST in Binary Tree

    Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    

    Example 1:

    Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
    Output: 20
    Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
    Example 2:

    Input: root = [4,3,null,1,2]
    Output: 2
    Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
    Example 3:

    Input: root = [-4,-2,-5]
    Output: 0
    Explanation: All values are negatives. Return an empty BST.
    

    Constraints:

    The number of nodes in the tree is in the range [1, 4 * 104].
    -4 * 104 <= Node.val <= 4 * 104

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

code : 

    class Solution {
        public static class Info {
            boolean isBST;
            int min;
            int max;
            int curr_sum;

            Info(boolean isBST, int min, int max, int curr_sum) {
                this.isBST = isBST;
                this.min = min;
                this.max = max;
                this.curr_sum = curr_sum;
            }
        }

        public static class MaxInfo {
            int max_sum = 0;
        }

        public int maxSumBST(TreeNode root) {
            MaxInfo maxinfo = new MaxInfo();
            maxSumBSTcal(root, maxinfo);
            return maxinfo.max_sum;
        }

        public Info maxSumBSTcal(TreeNode root, MaxInfo maxinfo) {
            if (root == null) {
                return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }

            Info left_Info = maxSumBSTcal(root.left, maxinfo);
            Info right_Info = maxSumBSTcal(root.right, maxinfo);

            int min = Math.min(root.val, Math.min(left_Info.min, right_Info.min));
            int max = Math.max(root.val, Math.max(left_Info.max, right_Info.max));
            int curr_sum = left_Info.curr_sum + right_Info.curr_sum + root.val;

            if (!left_Info.isBST || !right_Info.isBST || root.val <= left_Info.max || root.val >= right_Info.min) {
                return new Info(false, min, max, curr_sum);
            }

        if (left_Info.isBST && right_Info.isBST) {

            maxinfo.max_sum = Math.max(maxinfo.max_sum, curr_sum);
            return new Info(true, min, max, curr_sum);
        }
        return new Info(true, min, max, curr_sum);
        }
    }
