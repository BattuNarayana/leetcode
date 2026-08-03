class Solution {
    public boolean isMonotonic(int[] nums) {
        int inc = 0, dcr = 0, n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>=nums[i-1]) inc++;
            if(nums[i]<=nums[i-1]) dcr++;
        }
        return inc==n-1 || dcr==n-1;
    }
}