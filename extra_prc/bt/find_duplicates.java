import java.util.*;
class find_duplicates {
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

    public static String helper(Node root,List<Node> list,Map<String,Integer> map) {
        if(root == null){
            return "$";
        }
        String left_str = helper(root.left,list,map);
        String right_str = helper(root.right,list,map);

        String str = root.data+left_str+right_str;

        map.put(str,map.getOrDefault(str,0)+1);

        if(map.get(str) == 2){
            list.add(root);
        }
        return str;
    }

    public static List<Node> findDuplicateSubtrees(Node root) {
        List<Node> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        helper(root,list,map);
        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


    
/*
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

*/


      List<Node> duplicates = findDuplicateSubtrees(root);
    for (Node node : duplicates) {
        System.out.print(node.data+" ");
    }

        
    }
}
// time : O(n)
// space : O(h)