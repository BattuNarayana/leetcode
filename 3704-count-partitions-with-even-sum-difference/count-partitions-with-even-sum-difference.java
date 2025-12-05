class Solution {
    public int countPartitions(int[] nums) {
        int total=0,count=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if((total-2*sum)%2==0){
                count++;
            }
            sum+=nums[i];
        }
        return count;
    }
}