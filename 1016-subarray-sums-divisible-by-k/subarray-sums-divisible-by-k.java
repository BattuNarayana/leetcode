class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefix = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : nums){
            prefix+=num;
            int rem = (prefix%k + k)%k; // This converts negative remainders into the range [0, k-1]
            if(map.getOrDefault(rem, 0) != 0){ // if the REM is already in the map , then 
                ans += map.get(rem);           // add the frequency of the REM
                map.put(rem, map.get(rem)+1);  // and put into the map

                // "First count how many old prefixes can pair with me, then add myself for future prefixes."
            }
            else{
                map.put(rem, 1);
            }
        }
        return ans;
    }
}