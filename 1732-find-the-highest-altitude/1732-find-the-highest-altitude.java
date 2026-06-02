class Solution {
    public int largestAltitude(int[] gain) {
        int sum = gain[0];
        for(int i=1;i<gain.length;i++){
            gain[i]+=gain[i-1];
            sum = Math.max(sum, gain[i]);
        }
        return sum>0 ? sum : 0;
    }
}