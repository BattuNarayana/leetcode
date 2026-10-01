class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] effort = new int[n][n];
        int[] dir = {-1, 0, 1, 0, -1};
        for(int i=0;i<n;i++){
            Arrays.fill(effort[i], (int)1e9);
        }
        effort[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int i = curr[1];
            int j = curr[2];

            if(currEffort != effort[i][j]) continue;
            for(int d=0;d<4;d++){
                int nr = i + dir[d];
                int nc = j + dir[d+1];
                if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
                int newEffort = Math.max(currEffort, grid[nr][nc]);

                if(newEffort < effort[nr][nc]){
                    effort[nr][nc] = newEffort;
                    pq.offer(new int[]{newEffort, nr, nc});
                }
            }
        }
        return effort[n-1][n-1];
    }
}