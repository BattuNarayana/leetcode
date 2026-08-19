class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = visiting, 2 = safe 
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(state[i]==0){
                dfs(i, graph, state);
            }
            if(state[i]==2) al.add(i);
        }
        return al; // since we iterate from 0 -> n-1, 'al' is already sorted in ascending order
    }
    boolean dfs(int u, int[][] graph, int[] state){
        if(state[u]==1) return false; // cycle detected
        else if(state[u]==2) return true; // a;ready safe

        state[u] = 1; // mark as visiting
        for(int v : graph[u]){
            if(!dfs(v, graph, state)) return false; // any path leads to cycle
        }
        state[u] = 2; // mark as safe
        return true;
    }
}