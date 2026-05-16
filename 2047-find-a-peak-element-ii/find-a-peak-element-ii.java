class Solution {

    // find row index having maximum element in column
    private int maxRow(int[][] mat, int col){

        int row = 0;

        for(int i = 1; i < mat.length; i++){

            if(mat[i][col] > mat[row][col]){
                row = i;
            }
        }

        return row;
    }

    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while(low <= high){

            // middle column
            int mid = low + (high - low) / 2;

            // row having max element in mid column
            int row = maxRow(mat, mid);

            int left =
                (mid - 1 >= 0)
                ? mat[row][mid - 1]
                : -1;

            int right =
                (mid + 1 < n)
                ? mat[row][mid + 1]
                : -1;

            // peak found
            if(mat[row][mid] > left &&
               mat[row][mid] > right){

                return new int[]{row, mid};
            }

            // move left
            else if(left > mat[row][mid]){
                high = mid - 1;
            }

            // move right
            else{
                low = mid + 1;
            }
        }

        return new int[]{-1,-1};
    }
}