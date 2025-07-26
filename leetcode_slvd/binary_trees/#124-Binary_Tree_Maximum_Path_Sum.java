logic : 


        START Helper
        |
        v
        [Base Case: If root is null, return 0]
        |
        v
        [Recursive Calls:]
        |- left = helper(root.left, res)   // Max path in left subtree
        |- right = helper(root.right, res) // Max path in right subtree
        |
        v
        [Update Global Maximum (res[0])]
        |- res[0] = max of:
            | 1. Current res[0]
            | 2. root.val (standalone node)
            | 3. root.val + left (node + left path)
            | 4. root.val + right (node + right path)
            | 5. root.val + left + right (full path through root)
        |
        v
        [Return Local Maximum]
        |- return max of:
            | 1. root.val (ignore children)
            | 2. root.val + left (node + left path)
            | 3. root.val + right (node + right path)
        END Helper



        START maxPathSum
        |
        v
        [Initialize res[] with -∞]
        |
        v
        [Call helper(root, res) to compute max path]
        |
        v
        [Return res[0] (global maximum)]
        END maxPathSum


time : O(N): Each node is visited exactly once



124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the nodes values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000


code : 
        class Solution {

            public int helper(TreeNode root,int [] res) {
                if(root == null){
                    return 0;
                }

                int left = helper(root.left,res);
                int right = helper(root.right,res);

                res[0] = Math.max(res[0],Math.max(root.val,Math.max(root.val+left,Math.max(root.val + right,root.val+left+right))));

                return Math.max(root.val,Math.max(root.val+left,root.val+right));

            }

            public int maxPathSum(TreeNode root) {
                int res[] = {Integer.MIN_VALUE}; 
                helper(root,res);

                return res[0];
            }
        }