import java.util.*;
class kth_level_of_tree {
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


// time : O(n)
// space : O(n)
    public static void kth_level_of_a_tree_using_rec(Node root,int k,int level){
        if(root == null){
            return;
        }
        if(k == level){
            System.out.print(root.data+" ");
            return;
        }
        kth_level_of_a_tree_using_rec(root.left,k,level+1);
        kth_level_of_a_tree_using_rec(root.right,k,level+1);
    }


    public static void kth_level_of_a_tree_using_iteration_lot(Node root,int k){
        if(root == null){
            return;
        }
        Queue <Node> q = new LinkedList <>();
        q.add(root);
        q.add(null);
        int level = 1;
        Node curr;
        while(!q.isEmpty()){
            curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    level++;
                    q.add(null);
                }
            }
            else{
                if(k == level){
                System.out.println(curr.data);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            
            }
        }
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


    kth_level_of_a_tree_using_iteration_lot(root,3);
    kth_level_of_a_tree_using_rec(root,3,1);


        
    }
}
