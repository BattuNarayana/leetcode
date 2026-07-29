class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int low=0, high = nums.length-1;
        while(low < high){
            if(nums[low] % 2 > nums[high] % 2){
                int temp = nums[low];
                nums[low++] = nums[high];
                nums[high--] = temp;
            }
            else if(nums[low] % 2 == 0){
                low++;
            }
            else{
                high--;
            }
        }
        return nums;
    }
}