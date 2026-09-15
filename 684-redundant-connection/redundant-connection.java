class Solution {
    int[] leaders;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        leaders = new int[n+1];
        size = new int[n+1];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            leaders[i] = i;
            size[i] = 1;
        }
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!merge(u, v)){
                ans.add(Math.min(u, v));
                ans.add(Math.max(u, v));
                break;
            }
        }
        int[] a = new int[ans.size()];
        int i=0;
        for(int ele : ans) a[i++] = ele;
        return a;
    }

    int find(int x){
        if(x==leaders[x]) return x;
        return leaders[x] = find(leaders[x]);
    }

    boolean merge(int a, int b){
        int sla = find(a);
        int slb = find(b);
        if(sla==slb) return false;
        if(size[sla]>=size[slb]){
            leaders[slb] = sla;
            size[sla] += size[slb];
        }
        else{
            leaders[sla] = slb;
            size[slb] += size[sla];
        }
        return true;
    }
}