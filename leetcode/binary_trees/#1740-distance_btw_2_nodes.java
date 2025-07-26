logic : 

        START
        |
        v
        [Find LCA of n1 and n2 using lca(root, n1, n2)]
        |
        v
        [Calculate distance from LCA to n1 (dist1 = lca_dist(lca, n1))]
        |
        v
        [Calculate distance from LCA to n2 (dist2 = lca_dist(lca, n2))]
        |
        v
        [Return (dist1 + dist2) as the total distance between n1 and n2]
        |
        v
        END


        START
        |
        v
        [Check if root is null]
        |-- (Yes) --> [Return -1 (node not found)]
        |-- (No)  --> 
                |
                v
                [Check if root.data == n]
                |-- (Yes) --> [Return 0 (distance is zero)]
                |-- (No)  --> 
                    |
                    v
                    [Recursively find distance in left subtree (left_dist = lca_dist(root.left, n))]
                    |
                    v
                    [Recursively find distance in right subtree (right_dist = lca_dist(root.right, n))]
                    |
                    v
                    [Check if both left_dist and right_dist are -1]
                    |-- (Yes) --> [Return -1 (node not found in subtree)]
                    |-- (No)  --> 
                            |
                            v
                            [Check if left_dist == -1]
                            |-- (Yes) --> [Return right_dist + 1 (node found in right subtree)]
                            |-- (No)  --> [Return left_dist + 1 (node found in left subtree)]
                            |
                            v
                            END


Complexity Type	Value
Time	O(n)
Space	O(h)


import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class dist_btw_2_nodes {

        public static Node lca(Node root,int n1,int n2){
             if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left_lca =  lca(root.left,n1,n2);
        Node right_lca =  lca(root.right,n1,n2);

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


        public static int dist_btw_2_nodes(Node root,int n1,int n2){
            Node lca = lca(root,n1,n2);

            int dist1 = lca_dist(lca,n1);
            int dist2 = lca_dist(lca,n2);

            return dist1 + dist2;
        }


        public static int lca_dist(Node root,int n){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int left_dist = lca_dist(root.left,n);
            int right_dist = lca_dist(root.right,n);

            if(left_dist == -1 && right_dist == -1){
                return -1;
            }
            else if(left_dist == -1){
                return right_dist + 1;
            }
            else{
                return left_dist + 1;
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


            System.out.println(dist_btw_2_nodes(root,4,7));
}
}
