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
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd,
                           int[] inorder, int inStart, int inEnd) {

        // base case
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // root from preorder
        TreeNode root = new TreeNode(postorder[postEnd]);

        // root index in inorder
        int inRoot = map.get(root.val);

        // left subtree size
        int numsLeft = inRoot - inStart;

        // build left subtree
        root.left = build(postorder, postStart, postStart + numsLeft - 1,
                          inorder, inStart, inRoot - 1);

        // build right subtree
        root.right = build(postorder, postStart + numsLeft, postEnd - 1,
                           inorder, inRoot + 1, inEnd);

        return root;
    }
}