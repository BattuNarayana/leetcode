class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            firstIndex.putIfAbsent(num, i);
            lastIndex.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int degree = 0;
        for (int freq : count.values()) {
            degree = Math.max(degree, freq);
        }

        int minLength = nums.length;

        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                minLength = Math.min(
                    minLength,
                    lastIndex.get(num) - firstIndex.get(num) + 1
                );
            }
        }

        return minLength;
    }
}