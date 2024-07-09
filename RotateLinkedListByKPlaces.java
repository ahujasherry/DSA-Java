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
    public ListNode rotateRight(ListNode head, int k) {
         if(head==null || k==0){
            return head;
        }
        ListNode q1=head,q2=head;
        int count=1;
        while(q1.next!=null){
            count++;
            q1=q1.next;
        }
        k=k%count;
        if(k==0){
            return head;
        }
        int i=0,j=count-k-1;
        while(i<j){
            q2=q2.next;
            i++;
        }
        q1.next=head;
        head=q2.next;
        q2.next=null;
        return head;
    }
}
