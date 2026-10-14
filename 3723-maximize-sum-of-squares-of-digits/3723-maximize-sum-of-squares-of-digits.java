class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num) return "";
        int[] digits = new int[num];
        int remaining = sum;
        for(int i=0;i<num && remaining>0;i++){
            int val = Math.min(9, remaining);
            digits[i] = val;
            remaining -= val;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : digits){
            sb.append(i);
        }
        return sb.toString();
    }
}