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
    public void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        TreeNode temp = null;
        while(!stk.isEmpty()){
            TreeNode t = stk.pop();
            if(t.right!=null) stk.push(t.right);
            if(t.left!=null) stk.push(t.left);
            if(temp == null) temp = t;
            else{
                temp.right = t;
                temp.left = null;
                temp = t;
            }
        }
        
    }
}