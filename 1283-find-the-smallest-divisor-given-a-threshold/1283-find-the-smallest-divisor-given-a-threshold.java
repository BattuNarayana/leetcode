class Solution {
    boolean gotDivisor(int[] a, int req, int curr){
        long sum = 0;
        for(int num : a){
            sum+= Math.ceil((double)num/curr);
        }
        return sum<=req;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int ans = 0;
        while(min<=max){
            int mid = min + (max - min) / 2;
            if(gotDivisor(nums, threshold, mid)){
                ans = mid;
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        return ans;
    }
}