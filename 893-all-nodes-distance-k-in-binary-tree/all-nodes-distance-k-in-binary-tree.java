/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int currLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel == k) break;
            currLevel++;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }

                if(parent.containsKey(node) && !visited.contains(parent.get(node))) {
                    q.offer(parent.get(node));
                    visited.add(parent.get(node));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
}