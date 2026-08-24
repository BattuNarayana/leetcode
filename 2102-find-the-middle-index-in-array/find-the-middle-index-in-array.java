class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0, left = nums[0];
        for(int n : nums) total +=n;
        for(int i=0;i<nums.length;i++){
            if(i==0 || i==nums.length-1){
                if(total-nums[i]==0) return i;
            }
            else{
                if(total-left-nums[i] == left) return i;
                left += nums[i];
            }
        }
        return -1;
    }
}