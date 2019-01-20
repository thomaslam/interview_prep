class LRUCache {
    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
        
        public Node(Node prev, Node next, int key, int value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private Node mostRecentlyUsed;
    private Node leastRecentlyUsed;
    private int currSize;
    private int maxSize;
    
    public LRUCache(int capacity) {
        maxSize = capacity;
        currSize = 0;
        mostRecentlyUsed = null;
        leastRecentlyUsed = mostRecentlyUsed;
        cache = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        Node tempNode = cache.get(key);
        Node prev = tempNode.prev;
        Node next = tempNode.next;
        if (mostRecentlyUsed.key == key) {
            return mostRecentlyUsed.value;
        }

        if (leastRecentlyUsed.key == key) {
            leastRecentlyUsed = next;
            leastRecentlyUsed.prev = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        
        mostRecentlyUsed.next = tempNode;
        tempNode.prev = mostRecentlyUsed;
        tempNode.next = null;
        mostRecentlyUsed = tempNode;
        return tempNode.value;
    }
    
    public void put(int key, int value) {
        Node tempNode = cache.get(key);
        if (tempNode == null) {
            if (mostRecentlyUsed == null) {
                mostRecentlyUsed = new Node(null, null, key, value);
                leastRecentlyUsed = mostRecentlyUsed;
                cache.put(key, mostRecentlyUsed);
            } else {
                Node newNode = new Node(mostRecentlyUsed, null, key, value);
                cache.put(key, newNode);
                mostRecentlyUsed.next = newNode;
                mostRecentlyUsed = newNode;
            }
            this.currSize += 1;
        } else {
            tempNode.value = value;
            Node prev = tempNode.prev;
            Node next = tempNode.next;
            
            if (mostRecentlyUsed.key == key) {
                return;
            }

            if (leastRecentlyUsed.key == key) {
                leastRecentlyUsed = next;
                leastRecentlyUsed.prev = null;
            } else {
                prev.next = next;
                next.prev = prev;
            }

            mostRecentlyUsed.next = tempNode;
            tempNode.prev = mostRecentlyUsed;
            tempNode.next = null;
            mostRecentlyUsed = tempNode;
        }
        
        if (this.currSize > this.maxSize) {
            int LRUkey = leastRecentlyUsed.key;
            cache.remove(LRUkey);
            Node next = leastRecentlyUsed.next;
            leastRecentlyUsed = next;
            leastRecentlyUsed.prev = null;
            this.currSize -= 1;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */