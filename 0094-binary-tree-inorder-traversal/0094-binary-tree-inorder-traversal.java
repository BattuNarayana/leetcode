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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return helper(root, ans);
    }
    List<Integer> helper(TreeNode node, List<Integer> ans){
        if(node == null) return new ArrayList<>();
        helper(node.left, ans);
        ans.add(node.val);
        helper(node.right, ans);

        return ans;
    }
}