package Questions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/description/
class LRUCache {
    static class Node{
        public int key;
        public int val;
        Node prev;
        Node next;

        Node(int k, int v){
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> m = new HashMap<>();
    int limit;

    void addNode(Node newNode){
        Node oldNext = head.next;

        head.next = newNode;
        oldNext.prev = newNode;

        newNode.next = oldNext;
        newNode.prev = head;
    }

    void delNode(Node oldNode){
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!m.containsKey(key)){
            return -1;
        }

        Node ansNode = m.get(key);
        int ans = ansNode.val;

        // Remove from last
        m.remove(key);
        delNode(ansNode);

        // Add again so it will go at starting
        addNode(ansNode);
        m.put(key, ansNode);

        return ans;
    }

    public void put(int key, int value) {
        // Check if contains, Remove if contains
        if (m.containsKey(key)){
            Node oldNode = m.get(key);
            delNode(oldNode);
            m.remove(key);
        }

        // Check limit
        if (m.size() == limit){
            // delete LRU(Least Recently Used)
            m.remove(tail.prev.key);
            delNode(tail.prev);
        }

        Node node = new Node(key, value);
        addNode(node);
        m.put(key, node);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        int ans = lRUCache.get(4);
        System.out.println(ans);
    }
}