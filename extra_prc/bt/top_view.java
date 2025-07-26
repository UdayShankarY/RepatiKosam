import java.util.*;
class top_view {
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
        Node node;
        int hd;
        Info(Node node,int hd){
                this.node = node;
                this.hd = hd;
            }
    }

    public static void top_view(Node root){
        if(root == null){
            return;
        }
        Queue <Info> q = new LinkedList <>();
        int min = 0,max = 0;
        q.add(new Info(root,0)); 
        q.add(null);
        Node curr;
        while(!q.isEmpty()){
            curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.node,curr.hd);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }
        for(int i =min;i<max;i++){
            System.out.println(map.get(i).data+" ");
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


        top_view(root);


        
    }
}
// time : O(n)
// space : O(h)