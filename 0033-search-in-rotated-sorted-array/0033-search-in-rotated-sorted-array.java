class Solution {

    static int getPivotIndex(int[] nums){
        int n = nums.length;
        int s = 0;
        int e = n-1;
        int ans = -1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] <= nums[n-1]){
                e = mid-1;
            }
            else{
                ans = mid;
                s = mid+1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] nums, int start, int end, int target){
        int mid = -1;
        while(start <= end){
            mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivotIndex = getPivotIndex(nums);
        if(pivotIndex == -1){
            int ans = binarySearch(nums, 0, n-1, target);
            return ans;
        }
        
        else{
            int startArray1 = 0;
            int endArray1 = pivotIndex;
            if(target >= nums[startArray1] && target <= nums[endArray1]){
                int ans = binarySearch(nums, startArray1, endArray1, target);
                return ans;
            }

            
            int startArray2 = pivotIndex+1;
            int endArray2 = n-1;
            if(target >= nums[startArray2] && target <= nums[endArray2]){
            int ans = binarySearch(nums, startArray2, endArray2, target);
            return ans;
            }
        }
        return -1;
    }
}