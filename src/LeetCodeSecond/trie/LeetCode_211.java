package LeetCodeSecond.trie;

import java.util.TreeMap;

/**
 * @Author: wky233
 * @Date: 2020/7/24 20:12
 * @Description:
 */
public class LeetCode_211 {
    public Node root;
    /** Initialize your data structure here. */
    public LeetCode_211() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word,0,root);
    }
    public boolean search(String word, int index, Node cur) {
        if (index == word.length()){
            return cur.isWord;
        }
        char c = word.charAt(index);
        if (word.charAt(index) != '.'){
            if (cur.next.get(c) == null){
                return false;
            }
            return search(word,index+1, cur.next.get(c));
        }else {
            for (char ch : cur.next.keySet()) {
                if (search(word, index + 1, cur.next.get(ch))){
                    return true;
                }
            }
            return false;
        }
    }

    private class Node{
        public TreeMap<Character, Node> next;
        public boolean isWord;

        public Node() {
            next = new TreeMap<>();
        }
    }
}
