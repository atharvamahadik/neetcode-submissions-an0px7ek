class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            if(map.size()==capacity) {
                Node node = head.next;
                removeNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            addNode(node);
            map.put(key, node);
        }
    }

    private void addNode(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
    
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void moveToTail(Node node) {
        removeNode(node);
        addNode(node);
    }
}
