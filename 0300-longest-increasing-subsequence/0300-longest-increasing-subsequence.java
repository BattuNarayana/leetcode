class Solution {
    public int lengthOfLIS(int[] nums) {
        Set<Integer> st = new TreeSet<>();
        for(int x : nums) st.add(x);
        int[] nums2 = new int[st.size()];
        int i=0;
        for(int x : st){
            nums2[i++] = x;
        }
        return lcsLen(nums, nums2);
    }
    int lcsLen(int[] a, int[] b){
        int n1=a.length, n2=b.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                if(a[i]==b[j]) dp[i][j] = 1+dp[i+1][j+1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}