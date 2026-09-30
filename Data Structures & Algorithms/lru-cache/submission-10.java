class LRUCache {
    Map<Integer, Node> cache = new HashMap<>();
    int totalCapacity;

    public LRUCache(int capacity) {
        totalCapacity = capacity;
    }
    
    public int get(int key) {

        if (cache.containsKey(key)){
            moveToLast(cache.get(key));
            return cache.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)){
            cache.get(key).val= value;
            moveToLast(cache.get(key));
            return;
        }
        
        if(cache.size() == totalCapacity){
            Node evicted = evictFirst();
            cache.remove(evicted.key);
        }
        
        Node node = new Node(key, value);
        cache.put(key, node);
        insertAtLast(node);
    }

    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;

        public Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }

    private Node evictFirst(){
        Node evictedNode = head;
        head = head.next;
        return evictedNode;
    }

    private void moveToLast(Node node){
        if(tail == node){
            return;
        }

        if(head == node){
            head = head.next;
            head.prev = null;
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        insertAtLast(node);

    }

    private void insertAtLast(Node node){
        node.next = null;
        node.prev = null;

        if(head == null){
            head = node;
        }
        
        if(tail == null)
            tail = node;
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    
    }

    Node head = null;
    Node tail = null;
}


