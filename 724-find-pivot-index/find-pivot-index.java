class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==1) return 0;
        int total = 0;
        for(int num : nums) total += num;
        int left = 0;
        for(int i=0;i<nums.length;i++){
            if(total-nums[i]-left == left) return i;
            left+=nums[i];
        }
        return -1;
    }
}