class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high){
            if(nums[low]==target) return low;
            if(nums[high]==target) return high;
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){ // this means that the left half is sorted
                if(target>=nums[low] && target<nums[mid]){// <=nums[mid] is not written because we already wrote the condition above for mid 
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{ // this means that the right half is sorted
                if(target>nums[mid] && target<=nums[high]){ // >=nums[mid] is not written because we already wrote the condition above for mid 
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}