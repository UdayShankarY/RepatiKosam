import java.util.*;
class isunivalid {
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

     public static boolean helper(Node root,int val){
        if(root == null){
            return true;
        }
       

        if(root.data != val){
            return false;
        }   
        return helper(root.right,val) && helper(root.right,val);
    }
    public static boolean isunivalued(Node root){
        if(root == null){
            return true;
        }
        int val = root.data;

        return helper(root,val);

    }


    //or


    public static boolean isunivalued(Node root){
        if(root == null){
            return true;
        }
        int val = root.data;
        if(root.left != null && root.left.data != val){
            return false;
        } 
         if(root.right != null && root.right.data != val){
            return false;
        } 

        return isunivalued(root.left) && isunivalued(root.right);
    }

    

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(1);

/*
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

*/


        if(isunivalued(root)){
         System.out.println("it is unnivalues");

        }
        else{
            System.out.println("is not");
        }
        
    }
}
