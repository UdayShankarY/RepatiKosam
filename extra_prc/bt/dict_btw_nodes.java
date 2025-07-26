import java.util.*;
class dict_btw_nodes {
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


    public static Node lca(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node left_lca = lca(root.left,n1,n2);
        Node right_lca = lca(root.right,n1,n2);
        if(left_lca == null){
            return right_lca;
        }
        if(right_lca == null){
            return left_lca;
        }
        if(right_lca != null && left_lca != null){
            return root;
        }
        return null;
    }
    public static int dict(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int left_dict = dict(root.left,n);
        int right_dict = dict(root.right,n);

        if(left_dict == -1 && right_dict == -1){
            return -1;
        }
        else if(left_dict != -1){
            return left_dict+1;
        }
        else{
            return right_dict+1;
        }
    }


    public static int dict_btw_2_nodes(Node root,int n1,int n2){
        Node lca = lca(root,n1,n2);

        int leftdict = dict(lca,n1);
        int rightdict = dict(lca,n2);

        return 1+leftdict+rightdict;
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


        System.out.println("dict : "+dict_btw_2_nodes(root,4,5));
        
    }
}
