logic : 

    START findDuplicateSubtrees
    |
    v
    [Initialize:]
    |- ans = [] (list to store duplicate subtree roots)
    |- map = {} (hashmap to track serialization counts)
    |
    v
    [Trigger serialization and duplicate detection:]
    |- helper(root, ans, map)
    |
    v
    [Return the result list]
    |- return ans
    END


    START Helper
    |
    v
    [Base Case: If root is null, return "$" (marker for null nodes)]
    |
    v
    [Recursively serialize left and right subtrees:]
    |- left_str = helper(root.left, ans, map)
    |- right_str = helper(root.right, ans, map)
    |
    v
    [Create a unique string for the current subtree:]
    |- str = root.val + "," + left_str + "," + right_str
    |  (Example: "1,2,$,$,3,$,$" represents subtree rooted at 1 with left=2 and right=3)
    |
    v
    [Update HashMap:]
    |- map.put(str, map.getOrDefault(str, 0) + 1)
    |  - If `str` is new, add it with count=1.
    |  - If `str` exists, increment its count.
    |
    v
    [Check for Duplicates:]
    |- if (map.get(str) == 2):
    |     ans.add(root)  // Add root to result only on the *second* occurrence
    |
    v
    [Return the serialized string for parent nodes]
    |- return str
    END Helper


Complexity Type	Value
Time	O(n²) worst case
Space	O(n)


652. Find Duplicate Subtrees

Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]
 

Constraints:

The number of the nodes in the tree will be in the range [1, 5000]
-200 <= Node.val <= 200

code :


    class Solution {
        
        public String helper(TreeNode root,List<TreeNode> ans,Map <String,Integer> map) {

            if(root == null){
                return "$";
            }
            String left = helper(root.left,ans,map);
            String right = helper(root.right,ans,map);
            String str = root.val+","+left+","+right;

            map.put(str,map.getOrDefault(str,0)+1);

            if(map.get(str) == 2){
                ans.add(root);
            }
            return str;
        }

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> ans = new ArrayList<>();
            Map <String,Integer> map = new HashMap <>();
            helper(root,ans,map);
            return ans;
        }
}