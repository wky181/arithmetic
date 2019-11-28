package data_structure.hash;

import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

public class Test {
   private   MyHashMap<String,Integer> myHashMap = new MyHashMap<>();

    @Before
    public void put(){
        myHashMap.put("1",1);
        myHashMap.put("2",2);
        myHashMap.put("1",3);
        myHashMap.put("4",3);
        myHashMap.put("5",3);
        myHashMap.put("2",4);
        myHashMap.put(null,null);
        myHashMap.put(null,1);
    }
    @org.junit.Test
    public  void remove() {

        System.out.println(myHashMap.toString());
        myHashMap.remove("1");
        System.out.println(myHashMap.size());
        System.out.println( myHashMap.remove("1"));
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.toString());
        System.out.println(myHashMap.containsValue(-1));

    }
}
