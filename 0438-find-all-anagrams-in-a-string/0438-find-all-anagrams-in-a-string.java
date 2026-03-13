class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length()<p.length()) return res;
        int[] pCount = new int[26];
        int[] window = new int[26];
        for(char c : p.toCharArray()){
            pCount[c-'a']++;
        }
        int si=0, ei = 0;
        while(ei<s.length()){
            window[s.charAt(ei) - 'a']++;
            if(ei-si+1 >p.length()){
                window[s.charAt(si)-'a']--;
                si++;
            }
            if(Arrays.equals(pCount, window)){
                res.add(si);
            }
            ei++;
        }
        return res;
    }
}