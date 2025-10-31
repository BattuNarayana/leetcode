class Solution {
    public int superPow(int a, int[] b) {
        int MOD = 1337;
        a%=MOD;
        int result = 1;
        for(int i=b.length-1;i>=0;i--){
            result = (result*modPow(a,b[i]))%MOD;
            a = modPow(a,10);
        }
        return result;
    }
    public int modPow(int base, int exp){
        long result = 1;
        int mod = 1337;
        long x = base;
        while(exp>0){
            if((exp&1)==1){
                result = (result*x)%mod;
            }
            x = (x*x)%mod;
            exp>>=1;
        }
        return (int)result;
    }
}