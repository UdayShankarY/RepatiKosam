import java.util.*;
class Delete_Leaves_With_a_Given_Value {
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


    public static Node delete_tar(Node root,int tar){
        if(root == null){
            return null;
        }
        root.left = delete_tar(root.left,tar);
        root.right = delete_tar(root.right,tar);

        if(root.left == null && root.right == null && root.data == tar){
            return null;
        }
        return root;
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

/*
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

*/

        delete_tar(root,7);
        preorder(root);
    }
}
