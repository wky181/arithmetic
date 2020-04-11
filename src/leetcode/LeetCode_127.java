package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/2/25 23:01
 * @Description:
 */
public class LeetCode_127 {
    public static void main(String[] args) {
        String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list = Arrays.asList(strings);
        System.out.println(new LeetCode_127().twoBFS("hit", "cog", list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visit = new boolean[wordList.size()];
        Queue<Node> queue = new LinkedList<>();
        if (beginWord != null) {
            queue.offer(new Node(beginWord, 0));
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.string.equals(endWord)) {
                    return node.levle + 1;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    String s = wordList.get(j);
                    if (visit[j]) {
                        continue;
                    }
                    boolean check = check(node.string, s);
                    if (!check) {
                        continue;
                    }
                    visit[j] = true;
                    queue.offer(new Node(s, node.levle + 1));
                }
            }
        }
        return 0;
    }

    public boolean check(String node, String s) {
        if (node.length() != s.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < node.length(); i++) {
            if (s.charAt(i) != node.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }

        return count == 1;
    }

    class Node {
        public Node(String string, int levle) {
            this.string = string;
            this.levle = levle;
        }

        String string;
        int levle;
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) == -1) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 2;
        }
        boolean[] visit = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        if (beginWord != null) {
            queue.offer(beginWord);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) {
                    return count;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    String s = wordList.get(j);
                    if (visit[j]) {
                        continue;
                    }
                    boolean check = check(poll, s);
                    if (!check) {
                        continue;
                    }
                    visit[j] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public int twoBFS(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) == -1) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 2;
        }
        wordList.add(beginWord);
        boolean[] visit1 = new boolean[wordList.size()];
        boolean[] visit2 = new boolean[wordList.size()];
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count ++;
            if (queue1.size() > queue2.size()) {
                Queue queue = queue1;
                queue1 = queue2;
                queue2 = queue1;
                boolean[] tmp = visit1;
                visit1 = visit2;
                visit2 = tmp;
            }
            int size = queue1.size();
            while (size-- > 0){
                String s = queue1.poll();
                for (int i = 0; i < wordList.size() ; i++) {
                    if (visit1[i]){
                        continue;
                    }
                    if (!check(wordList.get(i),s)){
                        continue;
                    }
                    if (visit2[i]){
                        return count+1;
                    }
                    queue1.offer(s);
                    visit1[i] = true;
                }
            }
        }
        return 0;
    }

}
