class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
    public int atMost(int[] nums, int k){
        if(k<0) return 0;
        int left=0, count=0, odd=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]%2==1) odd++;
            while(odd>k){
                if(nums[left]%2==1){
                    odd--;
                }
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}