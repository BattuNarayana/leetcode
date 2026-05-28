/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        // MORRIS TRAVERSAL ( WITHOUT STACK & RECURSION) S.C = O(1)
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeNode curr = root;
        while(curr !=null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right = curr;
                    // ans.add(curr.val) , since it is inorder traversal, we should not process the curr b/f left
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    ans.add(curr.val); // curr is processed after the left BUT before RIGHT
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}