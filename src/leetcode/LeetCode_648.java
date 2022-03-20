package leetcode;

import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/20 10:15
 * @Description:
 */
public class LeetCode_648 {
    public String replaceWords(List<String> dict, String sentence) {
        for (String s: dict) {
            insert(s);
        }
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length ; i++) {
            String perfix = serchPerfix(strings[i]);
            if (perfix!=null){
                strings[i] = perfix;
            }
        }
        return String.join(" ",strings);
    }
    TrieNode root = new TrieNode();
    private class TrieNode {
        private final int K = 26;
        private TrieNode[] links;
        private  boolean isEnd;

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }

        public TrieNode() {
            this.links = new TrieNode[K];
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public boolean containKey(char ch){
            return links[ch - 'a'] != null;
        }

    }
    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length() ; i++) {
            char cur = word.charAt(i);
            if (!node.containKey(cur)){
                node.put(cur,new TrieNode());
            }
            node = node.get(cur);
        }
        node.setEnd();
    }
    private String serchPerfix(String word){
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length() ; i++) {
            char cur = word.charAt(i);
            if (node.containKey(cur)){
                builder.append(cur);
                node = node.get(cur);
                if (node.isEnd){
                    return builder.toString();
                }
            }else {
                return null;
            }

        }
        return null;
    }
}
