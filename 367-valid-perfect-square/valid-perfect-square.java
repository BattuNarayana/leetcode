class Solution {
    public boolean isPerfectSquare(int num) {
       int low = 0,high = num/2 +1;
       while(low<=high){
        int mid = low+(high-low)/2;
        long sqrt = (long)mid * (long)mid;
        if(sqrt<num) low = mid+1;
        else if(sqrt>num) high = mid-1;
        else return true;
       }
       return false;
    }
}