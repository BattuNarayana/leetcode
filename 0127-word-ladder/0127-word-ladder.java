class Pair{
    String s;
    int len;
    Pair(String s, int len){
        this.s = s;
        this.len = len;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.poll();
            String curr = p.s;
            int len = p.len;
            if(endWord.equals(curr)) return len;
            for(int i=0;i<curr.length();i++){
                char[] ch = curr.toCharArray();
                char original = ch[i];
                for(char j='a';j<='z';j++){
                    if(j == original) continue;
                    ch[i] = j;
                    String temp = new String(ch);
                    if(set.contains(temp)){
                        q.offer(new Pair(temp, len+1));
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}