class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int a : arr){
            if(a<=k) k++;
            else{
                break;
            }
        }
        return k;
    }
}