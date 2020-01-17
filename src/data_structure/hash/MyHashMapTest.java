package data_structure.hash;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.beans.Transient;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author 武凯焱
 * @date 2019/11/29 21:16
 * @Description:
 */
class MyHashMapTest {
    MyHashMap<String,Integer> myHashMap = new MyHashMap<>();
    @BeforeEach
    void put() {
        myHashMap.put("s1",1);
        myHashMap.put("s2",2);
        myHashMap.put("s3",3);
        myHashMap.put("s4",4);
        myHashMap.put("s5",5);
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void containsKey() {
    }

    @org.junit.jupiter.api.Test
    void containsValue() {
    }


    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void putAll() {
    }

    @org.junit.jupiter.api.Test
    void keySet() {
        MyHashSet set = myHashMap.keySet();
        System.out.println(set.toString());

    }

    @org.junit.jupiter.api.Test
    void values() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        Iterator iterator = myHashMap.iterator();
        while (iterator.hasNext()){
            MyHashMap.Node node = (MyHashMap.Node) iterator.next();
            System.out.println(" dsad "+node.key);
        }
    }
}