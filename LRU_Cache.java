class Node
{
    int key ;
    int value ;
    Node prev, next;

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    Map<Integer,Node> map;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;


    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head.next= tail;
        tail.prev = head;
    }
    
    public int get(int key)
    {
        //if present in map, return the value, and bring that integer to front of list
        if(map.containsKey(key))
        {
            Node node = map.get(key);

            deleteNode(node);
            addNode(node);
            return node.value;
        }   
        
        return -1;
        
    }
    
    public void put(int key, int value)
    {
        
        
        if (map.containsKey(key))
        {
            // Update the value and move the node to the front
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNode(node);
        } else {
            // Check capacity and remove LRU if needed
            if (map.size() == cap) {
                Node lru = tail.prev;
                map.remove(lru.key);
                deleteNode(lru);
            }

            // Add the new node
            Node newNode = new Node(key, value);
            addNode(newNode);
            map.put(key, newNode);
        }
       

    }

    public  void addNode(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void deleteNode(Node node)
    {
        Node prev= node.prev;
        Node next = node.next;
        prev.next= next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
