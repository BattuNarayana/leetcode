class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        
        for (int i = 0; i < n; i++) {
            // Add primary diagonal element
            sum += mat[i][i];
            
            // Add secondary diagonal element, making sure not to double-count the center element if n is odd
            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i];
            }
        }
        
        return sum;
    }
}