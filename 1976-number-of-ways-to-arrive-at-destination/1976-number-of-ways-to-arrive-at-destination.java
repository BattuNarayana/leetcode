class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_000 + 7;
        List<List<int[]>> adjl = buildGraph(n, roads);
        long[] time = new long[n];
        long[] ways = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        ways[0] = 1;

        Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0}); // (current shortest time, current node)

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long currTime = curr[0];
            int u = (int)curr[1];

            if (currTime != time[u]) continue;

            for(int[] ngh : adjl.get(u)){
                int v = ngh[0];
                int t = ngh[1];

                long newTime = currTime + t;

                if(newTime < time[v]){
                    time[v] = newTime;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newTime, v});
                } 
                else if(newTime == time[v]){
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int)ways[n-1];
    }

    List<List<int[]>> buildGraph(int n, int[][] roads){
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int t = road[2];

            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }
        return graph;
    }
}