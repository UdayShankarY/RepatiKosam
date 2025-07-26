import java.util.*;
class Minimum_Depth_of_Binary_Tree {
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


    public static int min_depth(Node root){
        if(root == null){
            return 0;
        }
        int left = min_depth(root.left);
        int right = min_depth(root.right);

        if(root.left == null){
            return right+1;
        }
        if(root.right == null){
            return left+1;
        }

        return 1+Math.min(left,right);
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


        System.out.println("lca : "+min_depth(root));
        
    }
}
