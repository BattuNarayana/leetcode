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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();
        if(root == null) return outer;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> inner = new ArrayList<>();
            while(sz-->0){
                TreeNode f = q.remove();
                inner.add(f.val);
                if(f.left!=null) q.add(f.left);
                if(f.right!=null) q.add(f.right);
            }
            outer.add(inner);
        }
        return outer;
    }
}