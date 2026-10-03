class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m=needle.length();
        if(m>n) return -1;
        int s=0;
        while(s<n-m+1){
            int i=s, j=0;
            while(j<=m){
                if(j==m) return s;
                if(haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    s++;
                    break;
                }
            }
        }
        return -1;
    }
}