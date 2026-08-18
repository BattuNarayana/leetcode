class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outDegree = new int[n];
        List<List<Integer>> reverseGraph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            reverseGraph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            outDegree[i] = graph[i].length;
            for(int neighbor : graph[i]){
                reverseGraph.get(neighbor).add(i);
            }
        }
        for(int i=0;i<n;i++){
            if(outDegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int curr= q.poll();
            ans.add(curr);
            for(int parent : reverseGraph.get(curr)){
                outDegree[parent]--;
                if(outDegree[parent]==0) q.offer(parent);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}