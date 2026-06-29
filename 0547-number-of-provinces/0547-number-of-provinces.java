class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int components = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                components++;
                dfs(isConnected, visited, i);
            }
        }
        return components;
    }
    void dfs(int[][] graph, boolean[] visited, int node){
        visited[node] = true;
        for(int neighbor=0;neighbor<graph.length;neighbor++){
            if(graph[node][neighbor]==1 && !visited[neighbor]){
                dfs(graph, visited, neighbor);
            }
        }
    }
}