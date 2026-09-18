class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int inf = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) Arrays.fill(dist[i], inf);
        for(int i=0;i<n;i++) dist[i][i] = 0;

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int wt = edge[2];
            dist[from][to] = wt;
            dist[to][from] = wt;
        }

        for(int m=0;m<n;m++){
            for(int s=0;s<n;s++){
                for(int e=0;e<n;e++){
                    if(dist[s][m]==inf || dist[m][e]==inf) continue;
                    else if(dist[s][m] + dist[m][e] < dist[s][e])
                        dist[s][e] = dist[s][m] + dist[m][e];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(dist[i][j]!=0 && dist[i][j]!=inf && dist[i][j]<=distanceThreshold) cnt++;
            }
            if(cnt<=min){
                min = cnt;
                idx = i;
            }
            cnt = 0;
        }

        return idx;
    }
}