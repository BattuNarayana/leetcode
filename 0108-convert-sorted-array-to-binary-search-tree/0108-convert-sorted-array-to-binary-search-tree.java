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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        // Base case: if left pointer crosses right, the sub-array is empty
        if (left > right) {
            return null;
        }
        
        // Find the middle element to maintain a height-balanced BST
        int mid = left + (right - left) / 2;
        
        // Create the root node with the middle value
        TreeNode current = new TreeNode(nums[mid]);
        
        // Recursively build the left and right subtrees
        current.left = helper(nums, left, mid - 1);
        current.right = helper(nums, mid + 1, right);
        
        return current;
    }
}