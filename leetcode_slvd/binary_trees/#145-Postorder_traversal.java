logic : 

    START countNodes(root)
    |
    v
    [Base Case:]
    |- if root == null → return 0  // Empty subtree has 0 nodes
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

Complexity Type	Value
Time	O(n)
Space	O(h) = O(n) worst


145. Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes values.

 Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?


code :

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        postorder(node.left, result);       // Visit left
        postorder(node.right, result);      // Visit right
        result.add(node.val);              // Visit root

    }
}
