import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode bottom;
    ListNode(int val) { this.val = val; this.next = null; this.bottom = null; }
}

public class Solution {
    public ListNode flatten(ListNode root) {
        if (root == null) return null;

        // Priority Queue (Min-Heap) to store nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Insert the head of each linked list into the heap
        ListNode current = root;
        while (current != null) {
            minHeap.offer(current);
            current = current.next;
        }

        // Dummy head for the result list
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        // Process the min-heap
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            tail.bottom = minNode;
            tail = tail.bottom;

            if (minNode.bottom != null) {
                minHeap.offer(minNode.bottom);
            }
        }

        // Return the flattened list, starting from the dummy head's bottom
        return dummyHead.bottom;
    }

    // Utility function to print the list using bottom pointers
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.bottom;
        }
    }

    public static void main(String[] args) {
        // Example usage
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(10);
        ListNode n3 = new ListNode(19);
        ListNode n4 = new ListNode(28);
        n1.bottom = new ListNode(7);
        n1.bottom.bottom = new ListNode(8);
        n1.bottom.bottom.bottom = new ListNode(30);
        n2.bottom = new ListNode(20);
        n3.bottom = new ListNode(22);
        n3.bottom.bottom = new ListNode(50);
        n4.bottom = new ListNode(35);
        n4.bottom.bottom = new ListNode(40);
        n4.bottom.bottom.bottom = new ListNode(45);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Solution solution = new Solution();
        ListNode flattenedList = solution.flatten(n1);

        // Print flattened list
        solution.printList(flattenedList);
    }
}
