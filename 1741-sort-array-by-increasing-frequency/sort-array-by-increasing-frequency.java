class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
         // Convert map keys to array
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if(map.get(a) != map.get(b))
                return map.get(a) - map.get(b);   // lower frequency first
            return b - a;                         // higher value first
        });

        // Convert Integer[] back to int[]
        for(int i = 0; i < n; i++){
            nums[i] = arr[i];
        }

        return nums;
    }
}