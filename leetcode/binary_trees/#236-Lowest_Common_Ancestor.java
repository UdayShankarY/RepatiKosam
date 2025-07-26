logic :

    START
    |
    v
    [Check if root is null OR root.val == p.val OR root.val == q.val]
    |-- (Yes) --> [Return root]
    |-- (No)  --> 
            |
            v
            [Recursively find LCA in left subtree (left_lca)]
            |
            v
            [Recursively find LCA in right subtree (right_lca)]
            |
            v
            [Check if left_lca is null]
            |-- (Yes) --> [Return right_lca]
            |-- (No)  --> 
                |
                v
                [Check if right_lca is null]
                |-- (Yes) --> [Return left_lca]
                |-- (No)  --> 
                        |
                        v
                        [Return root (since both left_lca and right_lca are not null)]
                        |
                        v
                        [END]


time : O(n)
space : O(n)


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left_lca =  lowestCommonAncestor(root.left,p,q);
        TreeNode right_lca =  lowestCommonAncestor(root.right,p,q);

        if(left_lca == null){
            return right_lca;
        }
        if(right_lca == null){
            return left_lca;
        }

        if(right_lca != null && left_lca != null){
            return root;
        }

        return null;
    }
}