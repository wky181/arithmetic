package LeetCodeSecond.trie;

import java.util.List;
import java.util.TreeMap;

/**
 * @Author: wky233
 * @Date: 2020/7/30 23:43
 * @Description:
 */
public class LeetCode_212 {
    Node root;
    int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        this.board = board;
        for (int i = 0; i < words.length ; i++) {
            addWord(words[i]);
        }
        return null;
    }
    public boolean dfs(Node node,int x, int y){
       return true;
    }

    public void  addWord(String word){
        Node cur = root;
        for (int i = 0; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (!cur.next.containsKey(ch)){
                cur.next.put(ch, new Node());
            }
            cur = cur.next.get(ch);
        }
        cur.isWord = true;
    }
    public boolean  searchWord(String word){
        Node cur = root;
        for (int i = 0; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (!cur.next.containsKey(ch)){
                return false;
            }
            cur = cur.next.get(ch);
        }
        return cur.isWord;
    }

    private class Node{
       public TreeMap<Character, Node> next;
       public boolean isWord;
       public Node() {
            next = new TreeMap<>();
        }
    }
}
