class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int j=0; // number of courses successfully completed
        int[] inDegree = new int[numCourses]; //index = node , its value = num od indegrees
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;
        }
        for(int i=0;i<numCourses;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            al.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<al.size();i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[j++] = curr;
            for(int neighbor : al.get(curr)){
                inDegree[neighbor]--;

                if(inDegree[neighbor]==0){
                    q.offer(neighbor);
                }
            }
        }
        if(j != numCourses)
            return new int[0];

        return ans;
    }
}