class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int cnt = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                cnt++;
                if(cnt>1) return false;
                if(i>0 && nums[i-1]>=nums[i+1]){
                    if(i+2<nums.length && nums[i]>=nums[i+2]) return false;
                }
            }
        }
        return true;
    }
}