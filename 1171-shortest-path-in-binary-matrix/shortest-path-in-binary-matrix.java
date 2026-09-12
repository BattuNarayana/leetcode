class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // if entry or exit is already blocked
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){  // if(grid[0][0]+grid[n-1][n-1]>=1)
            return -1;
        }

        int[] dir = {-1, -1, 0, 1, 1, 1, 0, -1, -1, -1}; //dx starts from 0, dy starts from 2
        int[][] dist = new int[n][n];
        for(int[] d : dist){
            Arrays.fill(d, (int)1e9);
        }
        dist[0][0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{1, 0, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currDis = curr[0];
            int i = curr[1];
            int j = curr[2];
            // Lazy deletion
            if(currDis != dist[i][j]){
                continue;
            }
            for(int k = 0; k < 8; k++){
                int newI = i + dir[k];
                int newJ = j + dir[k+2];
                // Valid cell + open cell
                if(newI >= 0 && newI < n && newJ >= 0 && newJ < n && grid[newI][newJ] == 0){
                    int newDist = currDis + 1;
                    if(newDist < dist[newI][newJ]){
                        dist[newI][newJ] = newDist;
                        pq.offer(new int[]{newDist, newI, newJ});
                    }
                }
            }
        }

        return dist[n-1][n-1] == (int)1e9 ? -1 : dist[n-1][n-1];
    }
}