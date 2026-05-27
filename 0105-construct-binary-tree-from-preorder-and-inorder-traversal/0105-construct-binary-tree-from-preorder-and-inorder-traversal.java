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

    Map<Integer, Integer> map =
        new HashMap<>();

    public TreeNode buildTree(
            int[] preorder,
            int[] inorder) {

        // store inorder indices
        for(int i = 0; i < inorder.length; i++) {

            map.put(inorder[i], i);
        }

        return build(preorder,
                     0,
                     preorder.length - 1,
                     inorder,
                     0,
                     inorder.length - 1);
    }

    private TreeNode build(
            int[] preorder,
            int preStart,
            int preEnd,
            int[] inorder,
            int inStart,
            int inEnd) {

        // base case
        if(preStart > preEnd ||
           inStart > inEnd) {

            return null;
        }

        // root from preorder
        TreeNode root =
            new TreeNode(preorder[preStart]);

        // root index in inorder
        int inRoot =
            map.get(root.val);

        // left subtree size
        int numsLeft =
            inRoot - inStart;

        // build left subtree
        root.left = build(
            preorder,
            preStart + 1,
            preStart + numsLeft,
            inorder,
            inStart,
            inRoot - 1
        );

        // build right subtree
        root.right = build(
            preorder,
            preStart + numsLeft + 1,
            preEnd,
            inorder,
            inRoot + 1,
            inEnd
        );

        return root;
    }
}