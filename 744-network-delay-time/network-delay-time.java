class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjl = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjl.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adjl.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currTime = curr[0];
            int u = curr[1];

            if(currTime>dist[u]) continue;

            for(int[] ngh : adjl.get(u)){
                int v = ngh[0];
                int weight = ngh[1];
                if(dist[u]+weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int maxTime = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == (int)1e9) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}