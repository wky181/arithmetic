package LeetCodeSecond.trie;

import java.util.TreeMap;

/**
 * @Author: wky233
 * @Date: 2020/7/24 17:04
 * @Description:
 */
public class Trie {

    private Node root;
    private int size;

    //迭代 添加单词
    public void addWord(String word){
        Node cur = root;
        for (int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }
    // 递归
    public void addWord1(String word,int index,Node cur){
        if (index == word.length()){
            if(!cur.isWord){
                cur.isWord = true;
                size++;
            }
            return;
        }
       char c = word.charAt(index);
       if (cur.next.get(c) == null){
           cur.next.put(c,new Node());
       }
       addWord1(word, index+1, cur.next.get(c));
    }

    // 查询单词
    public boolean search(String word){
        Node cur = root;
        for (int i = 0; i < word.length() ; i++) {
            char c =  word.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
    // 查询字典树中否有以Prefix为前缀的单词。
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null){
               return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public Trie(Node root,int size) {
        this.root = root;
        this.size = size;
    }

    public int getSize() {
        return size;
    }


    private class  Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;
    }
}
