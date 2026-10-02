class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    ans = Math.max(dfs(grid, i, j, m, n), ans);
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m ||j<0 || j>=n || grid[i][j]<=0) return 0;
        grid[i][j] = -1;
        int cnt = 1;
        for(int d=0;d<4;d++){
            int nr = i+dir[d];
            int nc = j+dir[d+1];
            cnt += dfs(grid, nr, nc, m, n);
        }
        return cnt;
    }
}