class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int num : nums){
            if(num<min) min = num;
            if(num>max) max = num;
        }
        
        return GCD(min, max);
    }
    public static int GCD(int a, int b) {
        return (b == 0) ? a : GCD(b, a % b);
    }
}