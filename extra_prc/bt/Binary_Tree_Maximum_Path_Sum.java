import java.util.*;
class Binary_Tree_Maximum_Path_Sum {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }


        public static int helper(Node root,int []res){
            if(root == null){
                return 0;
            }
            int left_path = helper(root.left,res);
            int right_path = helper(root.right,res);
            res[0] = Math.max(res[0],Math.max(root.data,Math.max(root.data+left_path,Math.max(root.data+right_path,root.data+right_path+left_path))));

            return Math.max(root.data,Math.max(right_path+root.data,left_path+root.data));
        }

    public static int max_path(Node root){
        int []res = {Integer.MIN_VALUE};
        helper(root,res);
        return res[0];
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

/*
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

*/
        System.out.println("max path : "+max_path(root));
        
    }
}
