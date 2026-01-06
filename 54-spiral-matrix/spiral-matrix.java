class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n-1;
        int top = 0, bottom = m-1;
        while(top<=bottom && left<=right){
            for(int i=left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int j=top;j<=bottom; j++){
                res.add(matrix[j][right]);
            }
            right--;
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            }
            if(left<=right){
            for(int j=bottom;j>=top;j--){
                res.add(matrix[j][left]);
            }
            left++;
            }
        }
        return res;
    }
}