import java.util.*;
class diameter_of_tree {
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

    public static class Info{
        int diameter;
        int height;

        Info(int dt,int ht){
            diameter = dt;
            height = ht;
        }
    }


// app 1 O(N)
    public static Info diameter(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int self_dia = 1+leftInfo.height+rightInfo.height;
        int diameter = Math.max(self_dia,Math.max(leftInfo.diameter,rightInfo.diameter));
        int height = 1+Math.max(leftInfo.height,rightInfo.height);

        return new Info(diameter,height);
    }

    // app 2 time O(n*n)
    public static int diameter2(Node root){
            if(root == null){
                return 0;
            }
            int leftDai = diameter2(root.left);
            int leftHeight = height(root.left);
            int rightDai = diameter2(root.right);
            int rightHeight = height(root.right);
            int self_dia = 1+leftHeight+rightHeight;
            return Math.max(self_dia,Math.max(leftDai,rightDai));
        }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int left_subtree = height(root.left);
        int right_subtree = height(root.right);

        return 1+Math.max(left_subtree,right_subtree);
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


        System.out.println("diameter of a tree : "+diameter(root).diameter);
        System.out.println("diameter of a tree : "+diameter2(root));
        
    }
}

// time and space : O(n)