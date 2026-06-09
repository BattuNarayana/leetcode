class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0, cnt=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            cnt+=map.getOrDefault(sum-goal, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }
}