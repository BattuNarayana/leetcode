class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<n+10;i++){
            int curr = product(i);
            if(curr%t==0) return i;
        }
        return 0;
    }
    int product(int n){
        int prod = 1;
        while(n>0){
            if(n%10==0) return 0;
            prod *= n%10;
            n/=10;
        }
        return prod;
    }
}