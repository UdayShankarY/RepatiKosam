import java.util.*;
class build_a_tree {
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

    static int idx = -1;
    public static Node build(int[] nodes){
        idx++;

        if(nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = build(nodes);
        newNode.right = build(nodes);

        return newNode;
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
        int []nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};

        Node root = build(nodes);
        preorder(root);
        
    }
}
