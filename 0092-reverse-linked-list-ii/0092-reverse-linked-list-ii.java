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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        if(left==1) return reverseFirstN(head, right);
        
        ListNode prev = head;
        for(int i=1;i<left-1;i++){
            prev=  prev.next;
        }
        prev.next = reverseFirstN(prev.next, right-left+1);

        return head;
    }

    public ListNode reverseFirstN(ListNode head, int n){
        ListNode prev = null;
        ListNode curr = head;
        while(n-->0){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head.next = curr;
        return prev;
    }
}