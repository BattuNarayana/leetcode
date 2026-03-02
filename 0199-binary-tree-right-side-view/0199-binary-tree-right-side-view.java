
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res = helper(root);
        for(List<Integer> inner : res){
            ans.add(inner.get(inner.size()-1));
        }
        return ans;
    }
    List<List<Integer>> helper(TreeNode r){
        List<List<Integer>> outer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);
        while(!q.isEmpty()){
            List<Integer> inner = new ArrayList<>();
        int size = q.size();
        for(int i=0;i<size;i++){
            TreeNode node = q.remove();
            inner.add(node.val);
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
        outer.add(inner);
        }
        return outer;
    }
}