class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }
        int cnt = 0;
        boolean hasOdd = false;
        for(int val :map.values()){
            if(val%2==0) cnt += val;
            else{
                 cnt += val-1;
                 hasOdd = true;
            }
        }
        if(hasOdd) cnt+=1;
        return cnt;
    }
}