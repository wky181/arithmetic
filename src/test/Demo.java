package test;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wky233
 * @Date: 2019/12/9 16:39
 * @Description:
 */
public class Demo {
    static final int[] temp = new int[5];
    public static void main(String[] args) throws IOException {
        temp[1] = 2;
        temp[1] = 3;
        System.out.println(temp[1]);
    //    temp = new int[2];
        double b = 0;
        int a = 3;
        System.out.println(a * 0.5);
        Integer num1 = 200;
        Integer num2 = 200;
        System.out.println(num1 == num2);
       /* System.out.println(99&(13-1));
        System.out.println(10%6);
        System.out.println(7&(4-1));*/
     /*  short i = 1;
       i += 1;
        System.out.println();*/
       /* LinkedList<String>  linkedList = new LinkedList<>();
        linkedList.add("dsfdsf");
        //linkedList.
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("wky");
        arrayList.add("233");
        File file = new File("temp.txt");
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(output);
        outputStream.writeObject(arrayList);
        outputStream.close();
        List<String> list = new ArrayList<>();
        Collections.synchronizedList(list);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1,1);
*/

    }
    public void test(int a, String string){
        System.out.println("aabb");
    }

    public void test(String string, int a){
        System.out.println("bbaa");
    }



}
