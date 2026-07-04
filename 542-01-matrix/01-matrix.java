class Pair{
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, 1, 0, -1};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        for(int[]a : dist){
            Arrays.fill(a, -1);
        }
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    dist[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }
        bfs(mat, dist, q);
        return dist;
    }
    void bfs(int[][] mat, int[][] dist, Queue<Pair> q){
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            for(int k=0;k<4;k++){
                int nr = row + x[k];
                int nc = col + y[k];
                if(nr<0 || nc<0 || nr>=mat.length || nc>=mat[0].length) continue;
                if(dist[nr][nc]==-1){
                    dist[nr][nc] = dist[row][col] + 1;
                    q.offer(new Pair(nr,nc));
                }
            }
        }
    }
}