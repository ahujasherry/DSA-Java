/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) 
    {
        if (head == null) return null;
        
        //old to new node
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while(temp!=null)
        { 
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp!=null)
        {
            //connect next nodes of new list nodes
            Node newListNode = map.get(temp);
            Node newListNextNode = map.get(temp.next);
            Node newListRandomNode = map.get(temp.random);
            
            newListNode.next = newListNextNode;

            //connect random 
            newListNode.random = newListRandomNode;

            temp=temp.next;
        }

        return map.get(head);
        
    }
}
