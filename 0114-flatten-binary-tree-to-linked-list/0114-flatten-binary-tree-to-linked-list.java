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
    // MORRIS STYLE FLATTENING
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode node = curr.left;
                while(node.right != null){
                    node = node.right;
                }
                node.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}