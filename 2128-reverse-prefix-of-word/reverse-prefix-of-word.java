class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int count = 0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                k = i;
                for(int j=i;j>=0;j--){
                    sb.append(word.charAt(j));
                }
                count++;
                break;
            }
        }
        if(count==0) return word;
        for(int l=k+1;l<word.length();l++){
            sb.append(word.charAt(l));
        }
        return sb.toString();
    }
}