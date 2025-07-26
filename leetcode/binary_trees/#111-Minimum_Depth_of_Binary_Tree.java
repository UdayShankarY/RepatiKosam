Logic : 

    START minDepth(root)
    |
    v
    [Base Case:]
    |- if root == null → return 0
    |
    v
    [Recursive Depth Calculation:]
    |- left_depth = minDepth(root.left)
    |- right_depth = minDepth(root.right)
    |
    v
    [Handle Missing Subtrees:]
    |- if root.left == null → return right_depth + 1
    |- if root.right == null → return left_depth + 1
    |
    v
    [Both Subtrees Exist:]
    |- return 1 + min(left_depth, right_depth)
    END

Time Complexity: O(N)
Space Complexity: O(H) (recursion stack height)


111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000


code : 

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left_depth = minDepth(root.left);
        int right_depth = minDepth(root.right);

        if(root.left == null){
            return (right_depth + 1);
        }
        if(root.right == null){
            return (left_depth + 1);
        }
        
        return (1+Math.min(left_depth,right_depth));
    }
}