class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(int num : magazine.toCharArray()){
            map[num-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            if(map[ch-'a']==0) return false;
            else{
                map[ch-'a']--;
            }
        }
        return true;
    }
}