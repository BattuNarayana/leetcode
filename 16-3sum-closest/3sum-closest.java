import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort for two-pointer traversal
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first triplet

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update if current sum is closer to target
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                // Move pointers intelligently
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // Exact match → can't get any closer
                    return currentSum;
                }
            }
        }

        return closestSum;
    }
}
