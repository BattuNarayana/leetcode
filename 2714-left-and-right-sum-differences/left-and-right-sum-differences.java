class Solution {
    public int[] leftRightDifference(int[] nums) {
        int left = 0, right = 0;
        for(int num : nums){
            right +=num;
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            right-=nums[i];
            ans = Math.abs(right-left);
            left+=nums[i];
            nums[i] = ans;
        }
        return nums;
    }
}