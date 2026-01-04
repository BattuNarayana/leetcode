class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }
            else{
                ans = num;
            }
        }
        return ans;
    }
}