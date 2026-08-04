class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        
        int i = 0;
        int curr = min;

        // Loop through the entire range from min to max
        while (curr <= max) {
            if (i < nums.length && nums[i] == curr) {
                // Number is present, skip duplicates if any
                while (i < nums.length && nums[i] == curr) {
                    i++;
                }
            } else {
                // Number is missing, record it
                ans.add(curr);
            }
            curr++; // Move to the next consecutive integer
        }
        return ans;
    }
}