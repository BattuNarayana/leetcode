class Solution {
    int MOD = 1_000_000_000 + 7;
    int[][][] dp;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        long left = countTill(num1, min_sum, max_sum);
        long right = countTill(num2, min_sum, max_sum);
        long result = (right - left + MOD)%MOD;
        if(leftNum(num1, min_sum, max_sum)) result++;
        return (int)(result % MOD);
    }
    boolean leftNum(String limit, int min_sum, int max_sum){
        int total = 0;
        for(int i=0;i<limit.length();i++) total += (limit.charAt(i)-'0');
        if(total>=min_sum && total<=max_sum) return true;
        return false;

    }

    int countTill(String limit, int min_sum, int max_sum){ // count good numbers from 0 till limit
        int n = limit.length();
        int maxPossibleSum = n*9;
        dp = new int[n+1][maxPossibleSum + 1][2];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<maxPossibleSum+1;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(limit, 0, 0, 1, min_sum, max_sum);
    }

    int helper(String limit, int i, int curr_digit_sum, int restricted, int min_sum, int max_sum){
        if(i>=limit.length()){
            if(curr_digit_sum >= min_sum && curr_digit_sum <= max_sum) return 1;
            else return 0;
        }

        //here - check DP for re-use and return
        if(dp[i][curr_digit_sum][restricted] != -1) return dp[i][curr_digit_sum][restricted];
        int mxDigit = (restricted==0) ? 9 : (limit.charAt(i) - '0');
        int total = 0;
        for(int d=0; d <= mxDigit; d++){
            int next_restricted = 0;
            if(restricted == 1){
                if(d==mxDigit) next_restricted = 1; 
            }
            total += helper(limit, i+1, curr_digit_sum + d, next_restricted, min_sum, max_sum);
            total = total % MOD;
        }

        return dp[i][curr_digit_sum][restricted] = total;
    }
}