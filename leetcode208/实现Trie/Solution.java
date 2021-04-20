package leetcode208.实现Trie;


// 实现堆，
public class Solution {
    class Trie {
        private TrieNode root; //根结点

        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word) { // 遍历word，拿出word的每一个char
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    ws.children[c - 'a'] = new TrieNode(c);
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public boolean search(String word) { // 对于word的每一个char，一层一层的往下查找，找有没有 isWord标志位
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        public boolean startsWith(String prefix) { //类似search
            TrieNode ws = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }

}

class TrieNode {
    public char val; // Node对应char的值
    public boolean isWord; //标记节点是不是word
    public TrieNode[] children = new TrieNode[26]; //子节点

    public TrieNode() {
    }

    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}