class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, candidates, target);
        return res;
    }
    public void backtrack(int idx, int[] nums, int t){
        if(t==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            if(nums[i]>t) continue;
            temp.add(nums[i]); 
            backtrack(i+1, nums, t-nums[i]);
            temp.remove(temp.size()-1);
        }
    }
}