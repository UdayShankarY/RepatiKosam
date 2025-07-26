
logic : 

        START (isSubtree)
        |
        V
        Is root null? ──YES──> RETURN false
        |
        NO
        |
        V
        Does root.val == subRoot.val? ──YES──> Call isIdentical(root, subRoot)
        |                                       |
        |                                       +──RETURN true (if identical)
        |                                       |
        |                                       NO──┐
        |                                           |
        NO                                          |
        |                                           |
        V                                           |
        Recursively check:                             |
        isSubtree(root.left, subRoot) OR               |
        isSubtree(root.right, subRoot)                 |
        |                                           |
        +───────────────────────────────────────────┘
        |
        V
        RETURN (true if either subtree contains subRoot, else false)





        START (isIdentical)
        |
        V
        Are both node and subRoot null? ──YES──> RETURN true
        |
        NO
        |
        V
        Is either node or subRoot null OR values different? ──YES──> RETURN false
        |
        NO
        |
        V
        Recursively check:
        |
        +── isIdentical(node.left, subRoot.left)
        |       |
        |       NO──> RETURN false
        |       |
        |       YES
        |
        +── isIdentical(node.right, subRoot.right)
                |
                NO──> RETURN false
                |
                YES
        |
        V
        RETURN true (both subtrees match)

Complexity Type	Value
Time	O(n * m)
Space	O(n + m)

572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this nodes descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104

code : 

class Solution {

        public boolean isIdentical(TreeNode node, TreeNode subRoot) {
            if(node == null && subRoot == null){
                return true;
            }
            else if(node == null || subRoot == null || node.val != subRoot.val){
                return false;
            }

            if(!isIdentical(node.left,subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right,subRoot.right)){
                return false;
            }
            return true;
        }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            if(isIdentical(root,subRoot)){
            return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
