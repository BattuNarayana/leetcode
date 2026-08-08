class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        int[] freq = new int[126];
        for(char ch : s.toCharArray()){
            freq[ch]++;
        }
        boolean hasOdd = false;
        for(int num : freq){
            if(num%2==0) ans+=num;
            else{
                ans += num-1;
                hasOdd = true;
            }
        }
        return hasOdd ? ans+1 : ans;
    }
}