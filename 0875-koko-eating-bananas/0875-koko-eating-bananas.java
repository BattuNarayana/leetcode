class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int time = timeTaken(piles, mid);
            if (time <= h) {
                high = mid;
            }
            else{
                low = mid +1;
            }
        }
        return low;
    }
    public int timeTaken(int[] piles, int mid){
        int total = 0;
        for(int num : piles){
            total += Math.ceil((double)num / mid);
        }
        return total;
    }
}