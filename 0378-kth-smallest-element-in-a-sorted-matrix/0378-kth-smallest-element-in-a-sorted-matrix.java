class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] a = new int[m*n];
        int l = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[l] = matrix[i][j];
                l++;
            }
        }
        Arrays.sort(a);
        return a[k-1];
    }
}