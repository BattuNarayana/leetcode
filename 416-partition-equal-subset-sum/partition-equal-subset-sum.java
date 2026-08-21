class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if((total&1)==1) return false;
        int target = total/2;
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                int inc = 0, exc = dp[i-1][j];
                if(nums[i-1]<=j) inc = dp[i-1][j-nums[i-1]];
                dp[i][j] = inc + exc;
            }
        }
        return dp[n][target]!=0;
    }
}