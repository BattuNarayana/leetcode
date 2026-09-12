class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores number and its index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate required number

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Return stored index and current index
            }

            // Store the current number with its index in the map
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // Should never happen
    }
}