class Solution {
    public List<String> buildArray(int[] target, int n) {
       List<String> ans = new ArrayList<>();
       int i=0;
       for(int j=1;j<=n && i<target.length;j++){
        ans.add("Push");
        if(j==target[i]) i++;
        else{
            ans.add("Pop");
        }
       }
       return ans;
    }
}