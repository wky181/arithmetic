package LeetCodeSecond.bfs;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/6/9 15:21
 * @Description:
 */
public class LeetCode_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hashSet = new HashSet<>(wordList);
        List<List<String>> lists = new ArrayList<>();
        if (hashSet.size() == 0 || !hashSet.contains(endWord)){
            return lists;
        }
        hashSet.remove(beginWord);
        HashSet<String> visited = new HashSet<>();
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(beginWord));
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size > 0){
                Node poll = deque.poll();
                char[] array = poll.value.toCharArray();
                for (int i = 0; i < array.length ; i++) {
                    for (char j = 'a'; j <= 'z' ; j++) {
                        if (array[i] == j){
                            continue;
                        }
                            array[i] = j;
                    }
                    String nextWord = String.valueOf(array);
                    if (wordList.contains(nextWord)){
                     //   poll
                        if (nextWord.equals(endWord)){

                        }
                    }
                }
            }
        }
        return lists;
    }
    private class Node{
        List<String> path = new ArrayList<>();
        String value;

        public Node(String value) {
            this.value = value;
           // path.add()
        }
    }
}
