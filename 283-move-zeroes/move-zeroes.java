class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        // int[] num = new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }
            else{
                nums[j++] = nums[i];
            }
        }
        for(int i=0;i<count;i++){
            nums[j++]=0;
        }
    }
}