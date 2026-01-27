class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int rep = -1,sum=0;
        for(int num : nums){
            sum+=num;
            if(set.contains(num)){
                rep = num;
            }
            else{
                set.add(num);
            }
        }
        int total = (nums.length*(nums.length+1))/2;
        int[] ans = new int[2];
        ans[0] = rep;
        ans[1] = total-sum+rep;
        return ans;
    }
}