class Solution {
    boolean isPossible(int[] arr, int m, int k, int mid){
        int cnt = 0,ans=0;
        for(int num : arr){
            if(mid>=num) cnt++;
            else{
                ans += cnt/k;
                cnt = 0;
            }
        }
        ans+=cnt/k;
        return ans>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int b : bloomDay){
            min = Math.min(min, b);
            max = Math.max(max, b);
        }
        while(min <= max){
            int mid = min + (max - min)/2;
            if(isPossible(bloomDay, m, k, mid)){
                ans = mid;
                max = mid-1;
            }
            else{
                min = mid + 1;
            }
        }
        return ans;
    }
}