class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int cnt = 0;
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[j]<nums[i]){
                    cnt++;
                }
            }
            ans[i] = cnt;
            cnt = 0;
        }
        return ans;
    }
}