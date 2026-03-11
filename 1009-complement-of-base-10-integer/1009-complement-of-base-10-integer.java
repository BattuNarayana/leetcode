class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        int sum = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(s.length()-i-1) == '0'){
                sum+= Math.pow(2, i);
            }
        }
        return sum;
    }
}