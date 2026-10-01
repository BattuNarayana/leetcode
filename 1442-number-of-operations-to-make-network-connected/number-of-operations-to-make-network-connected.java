class UFDS{
    int comp;
    int[] leaders;
    int[] size;
    public UFDS(int n){
        comp = n;
        leaders = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            leaders[i] = i;
            size[i] = 1;
        }
    }
    int find(int x){
        if(x == leaders[x]) return x;
        return leaders[x] = find(leaders[x]);
    }
    void merge(int a, int b){
        int sla = find(a);
        int slb = find(b);

        if(sla == slb) return;

        if(size[sla]>size[slb]){
            leaders[slb] = sla;
            size[sla] += size[slb];
        } else {
            leaders[sla] = slb;
            size[slb] += size[sla];
        }
        comp--;
    }

}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        UFDS unionFind = new UFDS(n);
        for(int[] c : connections){
            unionFind.merge(c[0], c[1]);
        }

        int components = unionFind.comp;
        return components -1;
    }
}