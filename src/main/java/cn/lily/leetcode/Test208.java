package cn.lily.leetcode;

public class Test208 {
    static class TrieNode{
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode(){
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch) {
            return links[ch -'a']!= null;
        }
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
    static class Trie{
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currenChar = word.charAt(i);
                if (!node.containsKey(currenChar)) {
                    node.put(currenChar, new TrieNode());
                }
                node = node.get(currenChar);
            }
            node.setEnd();
        }
        public boolean search(String word) {
            TrieNode temp = searchPrefix(word);
            return temp != null && temp.isEnd();
        }
        public boolean startsWith(String prefix) {
            TrieNode temp = searchPrefix(prefix);
            return temp != null;
        }
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if(node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

    }
}
