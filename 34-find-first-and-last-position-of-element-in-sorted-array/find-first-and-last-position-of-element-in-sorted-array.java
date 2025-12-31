class Solution {
    public int[] searchRange(int[] nums, int target) {//my approach is O(n)..we can improve it by using binary search whose time complexity would be O(logn)
        int start=-1,end=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                if(start == -1) start = i;
                end =i;
            }
        }
        return new int[] {start,end};
    }
}