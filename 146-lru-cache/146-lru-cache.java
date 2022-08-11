class LRUCache {

   Node head = new Node(0, 0), tail = new Node(0, 0);//creating head and tail of (0,0) key-value pair
    Map < Integer, Node > map = new HashMap();
    int capacity;

    public LRUCache(int capacity) {//constructor to initialize capacity , and dobly ll
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {// if exits earlier in map
            Node node = map.get(key);//then get the node and perform remove and insert
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {//if the map contains the key , then fetch the value and replace it , since now it became LRU remove and insert right of head
            remove(map.get(key));
        }
        if (map.size() == capacity) {//if size of map is equal to given capacity then remove and insert
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        //break the connection from the node to be deleted 
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        //make the prev and next connection from head to node and vice versa
        //then from node to headnext and headnext to node
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node {//creating a dobly ll
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */