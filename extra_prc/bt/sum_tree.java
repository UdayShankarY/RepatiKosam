import java.util.*;
class sum_tree {
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

    public static int sum_tree(Node root){
        if(root == null){
            return 0;
        }
        int data = root.data;
        int leftsum = sum_tree(root.left);
        int rightsum = sum_tree(root.right);
        root.data = leftsum+rightsum;

        return data+root.data;
    }

      public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

/*
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

*/


        System.out.println(sum_tree(root));

        preorder(root);

        
    }
}
// time : O(n)
// space : O(h)