class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[0], currMax = 0, currMin = 0;
        for(int num : nums){
            currMax += num;                 // --|
            max = Math.max(max, currMax);   //   |
            if(currMax<0){                  //   |-----   KADANE'S ALGORITHM
                currMax = 0;                //   |
            }                               // --|

            currMin += num;                 // --|
            min = Math.min(min, currMin);   //   |
            if(currMin>0){                  //   |-----   REVERSE KADANE'S ALGORITHM
                currMin = 0;                //   |
            }                               // --|
        }
        return Math.max(max, Math.abs(min));
    }
}