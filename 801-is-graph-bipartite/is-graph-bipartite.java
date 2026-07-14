class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] color = new int[m];
        for(int j=0;j<m;j++){  // The graph caan be disconnected also, so traverse every node
            if(color[j]==0) { 
                color[j] = 1;
                q.offer(j);
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int i=0;i<graph[node].length;i++){
                        int neighbor = graph[node][i];
                        if(color[neighbor]==0){
                            q.offer(neighbor);
                            color[neighbor] = 3-color[node];
                        }
                        else{
                            if(color[neighbor] == color[node]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}