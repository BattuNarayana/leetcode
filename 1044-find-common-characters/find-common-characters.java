class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }
        
        for (int i = 1; i < words.length; i++) {
            int[] currentFreq = new int[26];
            for (char c : words[i].toCharArray()) {
                currentFreq[c - 'a']++;
            }
            
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], currentFreq[j]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                ans.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        
        return ans;
    }
}