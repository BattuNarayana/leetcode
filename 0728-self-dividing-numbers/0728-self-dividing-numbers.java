class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isDividing(i)) ans.add(i);
        }
        return ans;
    }
    boolean isDividing(int num){
        int temp = num;
        while(temp>0){
            if(temp%10==0) return false;
            if(num%(temp%10)!=0) return false;
            temp /= 10;
        }
        return true;
    }
}