//https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150

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
    public ListNode removeNthFromEnd(ListNode head, int k) 
    {
        //calculate length
        ListNode fast  = head;

        for(int i=1;i<=k;i++)
        {
                fast=fast.next;
        }

        if(fast==null){
            return head.next;
        }
        ListNode slow = head;

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
       
        slow.next = slow.next.next;
        return head;
    }
}
