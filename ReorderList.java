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

//https://leetcode.com/problems/reorder-list/
class Solution {
    public void reorderList(ListNode head) 
    {
        ListNode slow = head, fast = head, prev = null;

        if(head.next==null) return ;

        //find middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut and Reverse second part
        prev.next = null;
        ListNode second = reverseList(slow);
        
        // Merge parts in special order
        mergeLists(head, second);
    }

    private ListNode reverseList(ListNode head) {
        // Code from previous Daily Task
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

     private void mergeLists(ListNode first, ListNode second) 
     {
         while (first != null && second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            if (temp1 == null) {
                break;
            }

            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        

       
    
    }
}
