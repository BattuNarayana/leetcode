class Solution {
    public boolean isGoodArray(int[] nums) {
        int g = nums[0];
        for(int num : nums){
            g = findGCD(g, num);
        }
        return g==1;
    }
    int findGCD(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}