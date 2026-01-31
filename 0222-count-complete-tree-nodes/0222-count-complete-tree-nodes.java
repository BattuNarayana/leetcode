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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh = 0,rh=0;
        TreeNode temp = root;
        while(temp!=null){
            lh++;
            temp = temp.left;
        }
        temp = root;
        while(temp!=null){
            rh++;
            temp = temp.right;
        }
        if(lh==rh){  //lucky- this Complete BT is perfect
            return(1<<lh) -1;
        }
       
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}