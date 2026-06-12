class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if(map.containsKey(si)){
                if(map.get(si) != ti) return false;
            }
            else{
                if(map.containsValue(ti)) return false;
                map.put(si, ti);
            }
        }
        return true;
    }
}