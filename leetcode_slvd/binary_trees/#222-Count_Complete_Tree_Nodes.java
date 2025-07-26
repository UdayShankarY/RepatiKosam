logic : 

    START countNodes(root)
    |
    v
    [Base Case:]
    |- if root == null → return 0  // Empty tree has 0 nodes
    |
    v
    [Recursive Count:]
    |- left_count = countNodes(root.left)   // Count nodes in left subtree
    |- right_count = countNodes(root.right) // Count nodes in right subtree
    |
    v
    [Return Total:]
    |- return 1 + left_count + right_count  // Current node + left + right counts
    END


Time Complexity: O(N)
(Each node is visited exactly once)

Space Complexity: O(H)
(Recursion stack space, where H = tree height; worst case O(N) for skewed trees)


222. Count Complete Tree Nodes

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.



code: 

    class Solution {
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }

            int left_sub = countNodes(root.left);
            int right_sub = countNodes(root.right);

            return (1 + left_sub + right_sub);
        }
    }