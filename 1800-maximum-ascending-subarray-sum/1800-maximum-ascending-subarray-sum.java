class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=nums[0],sum=nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]) sum+=nums[i+1];
            else{
                max = Math.max(max, sum);
                sum = nums[i+1];
            }
        }
        return Math.max(sum, max);
    }
}