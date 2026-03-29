class Solution {
    int canSplit(int[] nums, int mid) {
        int sum = 0;
        int sa = 1;
        for (int num : nums) {
            if (sum + num <= mid) {
                sum += num;
            } else {
                sa++;
                sum = num;
            }
        }
        return sa;
    }

    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, mid) <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}