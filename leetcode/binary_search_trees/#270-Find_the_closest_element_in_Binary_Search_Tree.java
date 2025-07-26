import java.util.*;

class Find_the_closest_element_in_Binary_Search_Tree{
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
        static int closest_val = -1;
        static int min_diff = Integer.MAX_VALUE;
        public static Info largestBST(TreeNode root,int k) {
            if(root == null){
                return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            }
            Info leftInfo = largestBST(root.left,k);
            Info rightInfo = largestBST(root.right,k);

            int size = leftInfo.size + rightInfo.size + 1;
            int diff = Math.abs(root.val - k);
            int min = Math.min(root.val,Math.min(leftInfo.min , rightInfo.min));
            int max = Math.max(root.val,Math.max(leftInfo.max , rightInfo.max));

            if(root.val > rightInfo.min || root.val < leftInfo.max){
                return new Info(false,size,min,max);
            }
            if(leftInfo.isBST && rightInfo.isBST){
                if (diff < min_diff) {
                     min_diff = diff;
                    closest_val = root.val;
}
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

        Info node = largestBST(root,85);
        System.out.println(max_bst);
        System.out.println("the minimum absolute difference is "+min_diff+" of node : "+closest_val);
           
}
}

