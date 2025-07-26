logic : 

    START isUnivalTree(root)
    |
    v
    [Base Case 1:]
    |- if root == null → return true (empty tree is trivially univalued)
    |
    v
    [Store root value:]
    |- val = root.val
    |
    v
    [Initiate Preorder Check:]
    |- return preorder(root, val)
    END isUnivalTree


    START preorder(root, val)
    |
    v
    [Base Case 2:]
    |- if root == null → return true (reached leaf without mismatch)
    |
    v
    [Value Mismatch Check:]
    |- if root.val != val → return false (found non-univalued node)
    |
    v
    [Recursive Check Subtrees:]
    |- return preorder(root.left, val) && preorder(root.right, val)
    |  (Both subtrees must be univalued)
    END preorder

Time: O(N) - Visits every node exactly once
Space: O(H) - Recursion stack height (worst case O(N) for skewed trees)


965. Univalued Binary Tree

A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.

 

Example 1:


Input: root = [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: root = [2,2,2,5,2]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val < 100


code :

    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if(root == null){
                return true;
            }

            int val = root.val;

            return preorder(root,val);
        }
        public static boolean preorder(TreeNode root,int val) {
            if(root == null){
                return true;
            }

        if(root.val != val){
            return false;
        }

            return preorder(root.left,val) && preorder(root.right,val);
        }
        
    }