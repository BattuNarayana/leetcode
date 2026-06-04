class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int i=0;
        for(int num : nums){
            xor^=num;
            xor^=i;
            i++;
        }
        return xor^i;
    }
}