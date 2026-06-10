class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, n = cardPoints.length;
        for(int i=0;i<n;i++){
            sum += cardPoints[i];
        }
        if(n==k) return sum;
        return sum - minSubarray(cardPoints, n - k);
    }
    public int minSubarray(int[] nums, int k){
        int left=0,sum=0,min=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum += nums[right];
            if(right-left+1>k){
                sum-=nums[left];
                left++;
            }
            if(right-left+1 ==k) min = Math.min(min, sum);
        }
        return min;
    }
}