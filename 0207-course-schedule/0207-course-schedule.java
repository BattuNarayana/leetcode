class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
        
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, pathVisited)) return false;
            }
        }
        return true;
    }
    boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited){
        visited[i] = true;
        pathVisited[i] = true;
        for(int next : adj.get(i)){
            if(!visited[next]){
                if(dfs(next, adj, visited, pathVisited)) return true;
            }
            else if(pathVisited[next]){
                return true;
            }
        }
        pathVisited[i] = false;
        return false;
    }
}