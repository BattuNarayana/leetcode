class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;
        for(int right=0;right<s.length();right++){
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(right)-'A']);
            while((right-left+1)-maxFreq >k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}