class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int si=0,ei=0,n=nums.length,sum=0,min=Integer.MAX_VALUE;
        while(ei<n){
            if(nums[ei]>=target) return 1;
            sum+=nums[ei];
            while(sum>=target){
                min = Math.min(min, ei-si+1);
                sum-=nums[si];
                si++;
            }
            ei++;
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }
}