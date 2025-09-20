class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Store words in HashSet for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // dp[i] = true if s[0..i) can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string can always be segmented

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further splits
                }
            }
        }

        return dp[s.length()];
    }
}
