class Solution {
    void dfs(int i, int j, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;
        grid[i][j] = 0;
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[0][i]==1) dfs(0, i, grid);
        }
        for(int i=0;i<m;i++){
            if(grid[i][0]==1) dfs(i, 0, grid);
        }
        for(int i=0;i<n;i++){
            if(grid[m-1][i]==1) dfs(m-1, i, grid);
        }
        for(int i=0;i<m;i++){
            if(grid[i][n-1]==1) dfs(i, n-1, grid);
        }
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
}