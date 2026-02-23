class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if(first==nums.length || nums[first]!=target) return new int[]{-1, -1};
        int last = upperBound(nums, target);
        return new int[]{first, last-1};
    }
    public int lowerBound(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            int ind = nums.length;
            if(nums[mid]>=target){
                ind = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public int upperBound(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            int ind = nums.length;
            if(nums[mid]>target){
                ind = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}