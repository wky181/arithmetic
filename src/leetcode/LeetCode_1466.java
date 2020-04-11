package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/3/11 14:41
 * @Description:
 */
public class LeetCode_1466 {
    public static void main(String[] args) {

    }
    LRU<Integer,Integer> lru ;
    public LeetCode_1466(int capacity) {
        lru = new LRU<>(capacity);
    }
    class LRU<K,V> extends LinkedHashMap<K,V>{
        private int capacity;
        public LRU(int capacity) {
            super(16, (float) 0.75,true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public int get(int key) {
        return lru.get(key);
    }

    public void put(int key, int value) {
        lru.put(key,value);
    }
}
