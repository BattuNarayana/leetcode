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
class NodeValue{
    int min;
    int max;
    int sum;
    NodeValue(int min, int max, int sum){
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}
class Solution {
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
    public NodeValue helper(TreeNode root){
        if(root == null) // empty subtree
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        //POSTORDER TRAVERSAL
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        // CHECK IF max(leftSubtree)<root.val AND root<min(right Subtree).....If TRUE, then the BT is valid BST
        if(left.max<root.val && root.val<right.min){
            int currSum =left.sum + right.sum + root.val;

            ans = Math.max(ans, currSum);

            return new NodeValue(
                Math.min(left.min, root.val),
                Math.max(right.max, root.val),
                currSum //sum of tree = sum(left Subtree) + sum(right Subtree) + root.val(itself)
            );
        }
        return new NodeValue(   // Means that either of the subtree is NOT a VALID BST
            Integer.MIN_VALUE,  // Min = MIN bcz it should not be greater than any other node's Min
            Integer.MAX_VALUE,  // Max = Max bcz it should not be lesser than any other node's Max
            0
        );
    }
}