import java.util.*;
class lowest_common_ansestor {
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
        if(left_lca != null && right_lca != null){
            return root;
        }
        return null;
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


        System.out.println("lca : "+lca(root,4,5).data);
        
    }
}
