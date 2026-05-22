class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left==right) return left;
        while(right>left){
            right = right &(right-1);
        }
        return left&right;
    }
}