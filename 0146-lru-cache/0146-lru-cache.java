class LRUCache {

    int capacity;
    HashMap<Integer, CDLLNode> map;
    CDLL list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new CDLL();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        CDLLNode node = map.get(key);
        list.moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            CDLLNode node = map.get(key);
            node.val = value;
            list.moveToFront(node);
        }
        else{
            if(map.size()>=capacity){
                int removedKey = list.removeLast();
                if(removedKey != -1){
                    map.remove(removedKey);
                }
            }

            CDLLNode newNode = list.insAtBegin(key, value);
            map.put(key, newNode);
        }
    }
}

class CDLLNode{
    int key, val;
    CDLLNode prev, next;
    public CDLLNode(int k, int v){
        key = k;
        val = v;
    }
}
class CDLL{
    CDLLNode head = null;
    int removeLast() {
        if (head == null) return -1;

        CDLLNode tail = head.prev;

        if (tail == head) {
            head = null;
        } else {
            tail.prev.next = head;
            head.prev = tail.prev;
        }

        return tail.key;
    }
    CDLLNode insAtBegin(int key, int val){
        CDLLNode newNode = new CDLLNode(key, val);
        if(head == null){
            head = newNode;
            head.next = head;
            head.prev = head;
        }
        else{
            CDLLNode tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        return newNode;
    }
    void moveToFront(CDLLNode node) {
        if (node == head) return;

        // Remove node from current position
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // Insert node before current head
        CDLLNode tail = head.prev;

        node.next = head;
        node.prev = tail;

        tail.next = node;
        head.prev = node;

        head = node;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */