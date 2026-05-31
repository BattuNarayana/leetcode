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
class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    boolean reverse;
    BSTIterator(TreeNode root, boolean reverse){
        this.reverse = reverse;
        pushAll(root);
    }
    public void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse) node = node.right;
            else node = node.left;
        }
    }
    int next(){
        TreeNode node = st.pop();
        if(reverse) pushAll(node.left);
        else pushAll(node.right);
        return node.val;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        int i = l.next();
        int j = r.next();
        while(i<j){
            int sum = i+j;
            if(sum == k) return true;
            if(sum<k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}