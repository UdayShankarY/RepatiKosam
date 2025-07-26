import java.util.*;
class count_of_nodes {
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


    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int left_subtree = countNodes(root.left);
        int right_subtree = countNodes(root.right);

        return 1+left_subtree + right_subtree;
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


        System.out.println("No of nodes : "+countNodes(root));
        
    }
}
