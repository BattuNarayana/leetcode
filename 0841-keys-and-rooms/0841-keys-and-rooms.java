class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        if(rooms.get(0).size()==0) return false;
        visited[0] = true;
        q.offer(0);
        int cnt = 1;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbor : rooms.get(curr)){
                if(!visited[neighbor]){
                    cnt++;
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        return cnt == rooms.size();
    }
}