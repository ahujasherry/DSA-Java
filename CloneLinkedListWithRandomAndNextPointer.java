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

    public void insertNode(Node head)
    {
         Node temp=head;
        while(temp != null){
            Node copy = new Node(temp.val);
             copy.next=temp.next;
         temp.next=copy;
         temp=temp.next.next;
        }
    }

    public void connectrandom(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copy = temp.next;

            if (temp.random != null) {
                copy.random = temp.random.next;
            }

            temp = temp.next.next;
        }
    }

    public Node getCopyNodeOpt(Node head) {
        Node dummyNode = new Node(-1);
        Node point = dummyNode;
        Node temp = head;

        while (temp != null) {
            // create next node
            point.next = temp.next;

            // restore node
            temp.next = temp.next.next;

            // move fwd
            temp = temp.next;
            point = point.next;
        }
        return dummyNode.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        insertNode(head);
        connectrandom(head);
        return getCopyNode(head);
    }

}
