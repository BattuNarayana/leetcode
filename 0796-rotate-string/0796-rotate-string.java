class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
         if (s.equals(goal)) return true;
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length()-1;i++){
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            if(sb.toString().equals(goal)) return true;
        }
        return false;
    }
}