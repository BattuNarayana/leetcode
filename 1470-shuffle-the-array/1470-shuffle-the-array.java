class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = nums[i];
        }
        int[] ans = new int[2*n];
        int j=0,k=0;
        for(int i=0;i<2*n;i++){
            if(i%2==0) ans[i]=temp[j++];
            else{
                ans[i] = nums[n+k];
                k++;
            }
        }
        return ans;
    }
}