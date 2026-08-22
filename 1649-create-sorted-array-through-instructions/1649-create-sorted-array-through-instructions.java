class Solution {
    public int createSortedArray(int[] a) {
        long ans = 0;
        int mxVal = 100000; // from constraints
        SegmentTree stObj = new SegmentTree(mxVal);
        for(int x : a){
            long cost1 = stObj.rangeQuery(0, x-1); // count of elements less than x 
            long cost2 = stObj.rangeQuery(x+1, mxVal); // count of elements greater than x
            ans = ans + Math.min(cost1, cost2);
            ans = ans % 1_000_000_007;
            stObj.incFreq(x);
        }
        return (int)ans;
    }
}
class SegmentTree{
    long[] st;
    int maxVal = 0;
    public SegmentTree(int maxVal){
        st = new long[4*maxVal];
        this.maxVal = maxVal;
    }
    long rangeQuery(int l, int r){
        return rangeHelper(0, 0, maxVal, l, r);
    }
    long rangeHelper(int idx, int ss, int se, int qs, int qe){
        if(qe < ss || qs>se) return 0L;
        if(ss >= qs && se <= qe) return st[idx];
        int mid = ss+(se-ss)/2;
        long left = rangeHelper(2*idx+1, ss, mid, qs, qe);
        long right = rangeHelper(2*idx+2, mid+1, se, qs, qe);
        return left+right;
    }
    void incFreq(int x){
        int idx=0, ss=0, se=maxVal;
        while(ss<se){
            int mid = ss+(se-ss)/2;
            if(x<=mid){ // go to left
                idx = 2*idx+1;
                se = mid;
            }
            else{ // go to right
                idx = 2*idx+2;
                ss = mid+1;
            }
        }
        // st[idx]++;

        // Propagate to ancestors
        while (idx > 0) {
            st[idx]++;
            idx = (idx - 1) / 2;
        }
    }
}