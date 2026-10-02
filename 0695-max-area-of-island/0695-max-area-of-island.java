class Solution {
    int[] leaders ;
    int[] size;

    public int find(int x){
        if(leaders[x] == x) return x;
        return leaders[x] = find(leaders[x]);
    }

    public int merge(int a, int b){
        int sla = find(a);
        int slb = find(b);

        if(sla == slb) return size[sla];

        if(size[sla] > size[slb]){
            leaders[slb] = sla;
            size[sla] += size[slb];
            return size[sla];
        } else {
            leaders[sla] = slb;
            size[slb] += size[sla];
            return size[slb];
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int totalCells = m*n;

        leaders = new int[totalCells];
        size = new int[totalCells];

        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int idx = i*n+ j;
                leaders[idx] = idx;
                if(grid[i][j]==1){
                    size[idx] = 1;
                    ans = 1;
                }
            }
        }

        int[] dir = {-1, 0, 1, 0, -1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int currIdx = i*n+j;
                    for(int d=0;d<4;d++){
                        int ni = i + dir[d];
                        int nj = j + dir[d+1];
                        if(ni<0 || ni>=m || nj<0 || nj>=n) continue;
                        if(grid[ni][nj] == 0) continue;
                        int nextIdx = ni*n + nj;
                       
                        ans = Math.max(ans, merge(currIdx, nextIdx));
                    }
                }
            }
        }
        return ans;
    }
}