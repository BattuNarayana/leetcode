class Solution {
    public void dfs(char[][] grid, int i, int j, int row, int col){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]=='0') return;
        grid[i][j] = '0';
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        for(int k=0;k<4;k++){
            dfs(grid, i+x[k], j+y[k], row, col);
        }

    }
    public int numIslands(char[][] grid) {
        int row=grid.length, col=grid[0].length;
        int islands = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]== '1'){
                    islands++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return islands;
    }
}