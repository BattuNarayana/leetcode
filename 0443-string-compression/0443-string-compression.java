class Solution {
    public int compress(char[] chars) {
        int j=0, curr=0;
        for(int i=0;i<chars.length;i++){
            char ch = chars[i];
            int freq = 0;
            while(i<chars.length){
                if(chars[i]==ch){
                    i++;
                    freq++;
                }
                else break;
            }
            i-=1;
            chars[j++] = ch;
            if(freq==1) continue;
            String s = Integer.toString(freq);
            for(int k=0;k<s.length();k++){
                chars[j++] = s.charAt(k);
            }
        }
        return j;
    }
}