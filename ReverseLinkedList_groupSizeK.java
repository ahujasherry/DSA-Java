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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode temp= head;
        ListNode prevLast = null;

        while(temp!=null)
        {
            //find kth node
            ListNode KthNode= findKthNode(temp,k);
            if(KthNode==null)
            {
                if(prevLast!=null)
                {
                    prevLast.next = temp;
                    break;
                }
            }

            //set future node
            ListNode nextNode= KthNode.next;
            KthNode.next = null;

            reverseLinkedList(temp);

            //first group, set new head or connect prev next to new group head
            if(temp==head)
            {
                head = KthNode;
            }else
            {
                prevLast.next = KthNode;
            }
            
            //update pointers
            prevLast = temp;
            temp = nextNode;

        }

        return head;
        
    }

    public static ListNode findKthNode(ListNode temp, int k)
    {
        k--;
        while(temp!=null && k>0)
        {
            k--;
            temp=temp.next;
        }

        return temp;
    } 

    static ListNode reverseLinkedList(ListNode head) {
        ListNode temp = head;  
   
       ListNode prev = null;  
       
       while(temp != null){  
           ListNode front = temp.next;  
           temp.next = prev;  
           prev = temp;  
           temp = front; 
       }
       
       return prev;  

    }


}
