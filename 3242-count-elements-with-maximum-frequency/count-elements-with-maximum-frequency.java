class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;

        // Count frequency of each number
        for (int num : nums) {
            int count = freq.getOrDefault(num, 0) + 1;
            freq.put(num, count);
            maxFreq = Math.max(maxFreq, count); // track max frequency
        }

        // Count how many elements have this max frequency
        int result = 0;
        for (int val : freq.values()) {
            if (val == maxFreq) {
                result += val; // add all occurrences of such numbers
            }
        }

        return result;
    }
}
