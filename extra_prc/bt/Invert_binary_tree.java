import java.util.*;
class Invert_binary_tree {
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
     public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node invert(Node root){
        if(root == null){
            return root;
        }
        invert(root.left);
        invert(root.right);
        
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
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


    preorder(root);
    System.out.println();        
    invert(root);
    preorder(root);
    }
}

// time and space : O(n)