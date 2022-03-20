package LeetCodeSecond.bfs;

import bluebridgecup_course.class_03.最小可用id;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;


/**
 * @Author: wky233
 * @Date: 2020/6/9 0:12
 * @Description:
 */
public class LeetCode_127 {
    boolean visit[] ;
    // 单向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>  wordSet = new HashSet<>();
        for (String str: wordList) {
            wordSet.add(str);
        }
        if (wordList.size() == 0 || !wordList.contains(endWord)){
            return 0;
        }
        wordSet.remove(beginWord);
        Deque<String> deque = new ArrayDeque<>();
        visit = new boolean[wordList.size()];
        deque.offer(beginWord);
        int count  = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size > 0){
                String poll = deque.poll();
                if (poll.equals(endWord)){
                    return count;
                }else {
                    addStr(poll,deque,wordList);
                }
                size--;
            }
            count++;
        }
        return 0;
    }

    private void addStr(String poll, Deque<String> deque, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (!visit[i] && check(wordList.get(i),poll)){
                deque.offer(wordList.get(i));
                visit[i] = true;
            }
        }
    }

    private boolean check(String s, String poll) {
        int count = 0;
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) != poll.charAt(i)){
                count++;
                if (count >= 2){
                    return false;
                }
            }
        }
        return count != 0;
    }
    // 双向BFS
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>  wordSet = new HashSet<>();
        HashSet<String>  beginSet = new HashSet<>();
        // 保存beginSet访问过的元素
        HashSet<String> visited = new HashSet<>();
        HashSet<String>  endSet = new HashSet<>();
        for (String str: wordList) {
            wordSet.add(str);
        }
        if (wordList.size() == 0 || !wordList.contains(endWord)){
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        while (!beginSet.isEmpty()){
            // 使begin永远是数量小的一方进行扩散，其实大体是两者交替进行
            if (beginSet.size() > endSet.size()){
                HashSet tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            // beginset扩散完成，扩散获取的元素放入新的集合
            HashSet<String> newBeginset = new HashSet<>();
            for (String s : beginSet) {
                char[] array = s.toCharArray();
                for (int i = 0; i < array.length ; i++) {
                    char c = array[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (c == j){
                            continue;
                        }
                        array[i] = j;
                        String nextWord = String.valueOf(array);
                        if (wordSet.contains(nextWord)){
                            if (endSet.contains(nextWord)){
                                // 两边集合都包含了nextWord,找到结果
                                return step+1;
                            }
                            // 如果对面没有而自己有了nextWord,不再扩散,防止形成圈
                            else if (!visited.contains(nextWord)){
                                newBeginset.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                        // 回溯下次使用
                        array[i] = c;
                    }

                }
            }
            // 完成扩散
            beginSet =  newBeginset;
            step++;
        }
        return 0;
    }

}
