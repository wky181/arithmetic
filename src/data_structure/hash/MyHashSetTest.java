package data_structure.hash;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 武凯焱
 * @date 2019/11/29 21:56
 * @Description:
 */
class MyHashSetTest {
    MyHashSet<Integer> myHashSet = new MyHashSet<>();
    @BeforeEach
    void add() {
        myHashSet.add(4);
        myHashSet.add(3);
        myHashSet.add(1);
        myHashSet.add(7);
        myHashSet.add(6);

    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
        System.out.println(myHashSet.contains(10));
    }


    @Test
    void remove() {
        myHashSet.remove(3);
        System.out.println(myHashSet.toString());
    }

    @Test
    void clear() {
    }

    @Test
    void iteraor() {
        Iterator<Integer> iteraor = myHashSet.iteraor();
        while (iteraor.hasNext()){
            System.out.println(iteraor.next());
        }
    }

    @Test
    void testToString() {
        System.out.println(myHashSet.toString());
    }
}