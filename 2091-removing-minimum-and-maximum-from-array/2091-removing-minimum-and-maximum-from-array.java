class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min=0,max=0;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[min]) min = i;
            if(nums[i]>nums[max]) max = i;
        }
        int left = Math.min(min, max);
        int right = Math.max(min, max);

        int op1 = right+1; // remove both from the front
        int op2 = n-left;  // remove both from the back
        int op3 = (left+1)+(n-right); // remove one from the front and one from the back

        return Math.min(op1, Math.min(op2, op3));
    }
}