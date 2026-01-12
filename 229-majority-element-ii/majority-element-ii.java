class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int mini = n/3 +1;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num)==mini){
                ans.add(num);
            }
            if(ans.size()==2) break;
        }
        return ans;
    }
}