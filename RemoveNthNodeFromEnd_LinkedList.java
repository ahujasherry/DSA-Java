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
        ListNode temp  = head;
        int len = 0;
        while(temp!=null)
        {
                len++;
                temp=temp.next;
        }
       
       if(len==k) return head.next;
       
        temp = head;
        for(int i=len-k-1;i>0; i--)
        {
                temp=temp.next;
        }


        temp.next = temp.next.next;
        
        return head;
    }
}
