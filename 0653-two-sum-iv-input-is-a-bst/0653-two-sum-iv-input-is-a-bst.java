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
    Set<Integer> st = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return pushAll(root, k);
    }
    public boolean pushAll(TreeNode root, int k){
        if(root==null) return false;
        if(st.contains(k - root.val)) return true;
        st.add(root.val);
        return pushAll(root.left, k) || pushAll(root.right, k);
    }
}