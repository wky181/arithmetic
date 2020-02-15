package test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/2/8 21:01
 * @Description:
 */
public class LRU<K,V> extends LinkedHashMap<K,V> {
    private static final int  MAX_ENTRIES  = 3;
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >  MAX_ENTRIES ;
    }

    public LRU() {
        super(MAX_ENTRIES,0.75f,true);
    }
   //git PriorityQueue

}
