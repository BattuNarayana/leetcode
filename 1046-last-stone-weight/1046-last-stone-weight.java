class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            p.add(s);
        }
        while(p.size()>1){
            int m1 = p.remove();
            int m2 = p.remove();
            if(m1 !=m2){
                p.add(m1-m2);
            }
        }
        if(p.isEmpty()) return 0;
        return p.peek();
    }
}