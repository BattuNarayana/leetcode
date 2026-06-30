class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int[] x = {-1, 0, 1, 0};
    public int[] y = {0, 1, 0, -1};
    int minutes = 0, fresh = 0;
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i, j, 0));
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
        bfs(grid, q, m, n);
        return fresh==0 ? minutes : -1;
    }
    void bfs(int[][] grid, Queue<Pair> q, int m, int n){
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            minutes = Math.max(minutes, time);
            for(int k=0;k<4;k++){
                int nr = row + x[k];
                int nc = col + y[k];
                if(nr<0 || nc<0 || nr>=m || nc>=n || grid[nr][nc]==0 || grid[nr][nc]==2) continue;
                grid[nr][nc] = 2;
                fresh--;
                q.offer(new Pair(nr, nc, time + 1));
            }
        }
    }
}