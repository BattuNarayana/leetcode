/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        Set<Integer> s = new HashSet<>();
        ListNode prev = head;
        ListNode temp = head;
        while(temp!=null){
            if(s.contains(temp.val)){
                prev.next = temp.next;
            }
            else{
                s.add(temp.val);
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}