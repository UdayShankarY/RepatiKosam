import java.util.*;

class size_of_largest_bst_in_bt{
    public static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    }

public static class Info{
    boolean isBST;
    int size;
    int min;
    int max;
        Info(boolean isBST,int size,int min,int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
}       

        static int max_bst = 0;
        public static Info largestBST(TreeNode root) {
            if(root == null){
                return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            }
            Info leftInfo = largestBST(root.left);
            Info rightInfo = largestBST(root.right);

            int size = leftInfo.size + rightInfo.size + 1;

            int min = Math.min(root.val,Math.min(leftInfo.min , rightInfo.min));
            int max = Math.max(root.val,Math.max(leftInfo.max , rightInfo.max));

            if(root.val > rightInfo.min || root.val < leftInfo.max){
                return new Info(false,size,min,max);
            }
            if(leftInfo.isBST && rightInfo.isBST){
                max_bst = Math.max(max_bst,size);
                return new Info(true,size,min,max);
            }
            
            return new Info(false,size,min,max);
        }
    
        public static void main(String[] args){
         
           // Constructing the following BST:
        /*
                      50
                    /    \
                  30      60
                 /  \    /  \
                5   20  45   70
                              / \
                             65  80
        */

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);

        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);

        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        Info node = largestBST(root);
        System.out.println(max_bst);
           
}
}

