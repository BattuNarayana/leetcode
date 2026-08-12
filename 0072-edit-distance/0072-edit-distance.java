class Solution {
    public int minDistance(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        int[][] dp = new int[n1+1][n2+1];
        int k = n1;
        for(int i=0;i<=n1;i++){
            dp[i][n2] = k--;
        }
        k = n2;
        for(int i=0;i<=n2;i++){
            dp[n1][i] = k--;
        }
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                if(a.charAt(i)==b.charAt(j)) dp[i][j] = dp[i+1][j+1];
                else dp[i][j] = 1+Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
            }
        }
        return dp[0][0];
    }
}