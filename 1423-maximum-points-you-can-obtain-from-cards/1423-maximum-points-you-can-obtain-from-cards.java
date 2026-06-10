class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0,right=cardPoints.length-1,sum=0,max=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        if(k==cardPoints.length) return sum;
        max = sum;
        for(int i = k - 1; i >= 0; i--){
            sum -= cardPoints[i];
            sum += cardPoints[right--];
            max = Math.max(max, sum);
        }
        return max;
    }
}