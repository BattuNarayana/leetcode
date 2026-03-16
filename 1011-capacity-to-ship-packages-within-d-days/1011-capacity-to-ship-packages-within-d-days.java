class Solution {
    boolean canShip(int[] arr, int days, int mid){
        int sum = 0, d=1;
        for(int w : arr){
            if(sum+w>mid){
                sum = 0;
                d++;
            }
            sum+=w;
        }
        return d<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE, high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low) / 2;
            if(canShip(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}