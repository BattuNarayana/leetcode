class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] isComposite = new boolean[n];
        isComposite[0] = true;
        isComposite[1] = true;
        int count = n-2;
        for(int i=2;i*i<n;i++){
            if(!isComposite[i]){
                for(int j=i*i;j<n;j+=i){
                    if(!isComposite[j]){
                        isComposite[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}