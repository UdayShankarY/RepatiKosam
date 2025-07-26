import java.util.*;
class subtree_of_another_tree {
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

        public static boolean isIdentical(Node root,Node subroot){
            if(root == null && subroot == null){
                return true;
            }
            if(root == null || subroot == null || root.data != subroot.data){
                return false;
            }
            if(!isIdentical(root.left,subroot.left)){
                return false;
            }
            if(!isIdentical(root.right,subroot.right)){
                return false;
            }
            return false;
        }

    public static boolean subtree(Node root,Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        return subtree(root.left,subroot) && subtree(root.right,subroot);
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


        System.out.println("is SubTree of a tree : "+subtree(root,subroot));
        
    }
}
// time : O(m * n)
// space : O(h)