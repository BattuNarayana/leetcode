class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i=1;i<=n/2;i++){
            if(n%i!=0) continue;
            String subString = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n/i;j++){
                sb.append(subString);
            }
            if(sb.toString().equals(s)){
                return true;
            }
            // if(n%i!=0) continue;
            // String subString = s.substring(0, i);
            // boolean matched = true;
            // for(int j=0;j<n;j+=i){
            //     if(!s.substring(j, j+i).equals(subString)){
            //         matched = false;
            //         break;
            //     }
            // }
            // if(matched) return true;
        }
        return false;
    }
}