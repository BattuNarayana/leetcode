class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low=0, high=nums.length-1;
        while(low<high){
            while(low<high && nums[low]%2==0) low++;
            while(high>low && nums[high]%2==1) high--;
            if(low<high){
                int temp = nums[low];
                nums[low++] = nums[high];
                nums[high--] = temp;
            }
        }
        return nums;
    }
}