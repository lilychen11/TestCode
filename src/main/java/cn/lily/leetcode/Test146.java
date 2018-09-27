package cn.lily.leetcode;

import java.util.*;

public class Test146 {
    public static class LRUCache {
        private int capacity = 0;
        private final float hashLoadFactor = 0.75f;
        private LinkedHashMap<Integer, Integer> map;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<Integer, Integer>((int)(capacity / hashLoadFactor) + 1, hashLoadFactor, true) {
                private static final long serialVersionUID = 1;

                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > LRUCache.this.capacity;
                }
            };
        }

        public void put(int key, int value) {
            map.put(key, value);
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
    }
    class LRUCache1{
        class DLinkedNode{
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode post;
        }
        private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
        private int count;
        private int capacity;
        private DLinkedNode head, tail;

        private void addNode(DLinkedNode node) {
            node.pre = head;
            node.post = head.post;
            head.post.pre = node;
            head.post = node;
        }
        private void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.pre;
            DLinkedNode post = node.post;
            pre.post = node.post;
            post.pre = pre;
        }
        private void moveToHead(DLinkedNode node) {
            this.removeNode(node);
            this.addNode(node);
        }
        private DLinkedNode popTail() {
            DLinkedNode res = tail.pre;
            this.removeNode(res);
            return res;
        }
        public LRUCache1(int capacity){
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            head.pre = null;

            tail = new DLinkedNode();
            tail.post = null;

            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            this.moveToHead(node);
            return node.value;
        }
        public void set(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;
                this.cache.put(key,newNode);
                this.addNode(newNode);
                 ++count;
                 if (count > capacity) {
                     DLinkedNode tail = this.popTail();
                     this.cache.remove(tail.key);
                     count--;
                 }
            } else {
                node.value = value;
                this.moveToHead(node);
            }
        }

    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));        // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));      // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }
}
