import java.util.*;
class Traversals {
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


    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }


    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void level_order(Node root){
        if(root == null){
            return;
        }
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        Node currnode;
        while(!q.isEmpty()){
            currnode = q.remove();
            if(currnode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currnode.data+" ");
                if(currnode.left != null){
                    q.add(currnode.left);
                }
                if(currnode.right != null){
                    q.add(currnode.right);
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

/*
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

*/


        preorder(root);
        System.out.println("");
        inorder(root);
        System.out.println("");
        postorder(root);
        System.out.println("");
        level_order(root);
    }
}

// Traversal Type	Time Complexity	Space Complexity
// Preorder	O(N)	O(H) (recursive stack)
// Inorder	O(N)	O(H) (recursive stack)
// Postorder	O(N)	O(H) (recursive stack)
// Level Order (BFS)	O(N)	O(N) (queue)