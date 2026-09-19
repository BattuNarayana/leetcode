class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            if(i!=0) row.add(1);
            ans.add(row);
        }
        return ans;
    }
}