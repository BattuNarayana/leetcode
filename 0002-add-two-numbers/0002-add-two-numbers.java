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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int a=0,b=0,c=0,sum=0,d=0;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(t1!=null || t2!=null){
            a = (t1==null) ? 0 : t1.val;
            b = (t2==null) ? 0 : t2.val;
            sum = a+b+c;
            d = sum%10;
            c = sum/10;

            tail.next = new ListNode(d);
            tail = tail.next;
            if(t1!=null) t1 = t1.next;
            if(t2!=null) t2 = t2.next;
        }
        if(c>0){
            tail.next = new ListNode(c);
            tail = tail.next;
        }
        return dummy.next;
    }
}