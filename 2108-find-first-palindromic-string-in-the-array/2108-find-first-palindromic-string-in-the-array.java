class Solution {
    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isP(word)) return word;
        }
        return "";
    }
    private boolean isP(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}