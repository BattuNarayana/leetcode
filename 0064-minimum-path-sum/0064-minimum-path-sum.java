class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        for(int i=1;i<c;i++){
            grid[0][i]+=grid[0][i-1];
        }
        for(int i=1;i<r;i++){
            grid[i][0]+=grid[i-1][0];
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                int min = Math.min(grid[i-1][j], grid[i][j-1]);
                grid[i][j]+=min;
            }
        }
        return grid[r-1][c-1];
    }
}