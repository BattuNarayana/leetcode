class Solution {
    public int findNthDigit(int n) {
        long len =1;
        long count = 9;
        long start = 1;
        while(n> len*count){
            n-=len*count;
            len++;
            start*=10;
            count*=10;
        }
        start+=(n-1)/len;
        String s = Long.toString(start);
        return s.charAt((int)((n-1)%len)) - '0';
    }
}