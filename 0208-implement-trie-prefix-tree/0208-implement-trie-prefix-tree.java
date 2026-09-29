class Node{
    Node[] children;
    boolean isEndOfWord;

    Node(){
        children = new Node[26];
        isEndOfWord = false;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(temp.children[idx] == null){
                temp.children[idx] = new Node();
            }
            temp = temp.children[idx];
        }
        temp.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Node temp = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(temp.children[idx] == null) return false;

            temp = temp.children[idx];
        }
        return temp.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;

        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';
            if(temp.children[idx] == null) return false;

            temp = temp.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */