logic : 

    START diameter(root)
    |
    v
    [Base Case:]
    |- if root == null → return new Info(0, 0)  // (diameter=0, height=0)
    |
    v
    [Recursive Calls:]
    |- left = diameter(root.left)   // Get left subtree info
    |- right = diameter(root.right) // Get right subtree info
    |
    v
    [Calculate Current Nodes Metrics:]
    |- self_diameter = left.ht + right.ht  // Path through current node
    |- final_diameter = max(self_diameter, left.diam, right.diam)
    |- height = 1 + max(left.ht, right.ht)
    |
    v
    [Return Package:]
    |- return new Info(final_diameter, height)
    END

Complexity Type	Value
Time	O(n)
Space	O(h) = O(n) worst


543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100

code :

    class Solution {
        public static class Info {
            int diam;
            int ht;

            Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public int diameterOfBinaryTree(TreeNode root) {
            return diameter(root).diam;
        }

        private Info diameter(TreeNode root) {
            if (root == null) {
                return new Info(0, 0); // diameter, height
            }

            Info left = diameter(root.left);
            Info right = diameter(root.right);

            int self_diameter = left.ht + right.ht; // edge count
            int final_diameter = Math.max(self_diameter, Math.max(left.diam, right.diam));
            int height = 1 + Math.max(left.ht, right.ht);

            return new Info(final_diameter, height);
        }
    }
