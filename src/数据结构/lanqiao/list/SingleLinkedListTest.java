package 数据结构.lanqiao.list;

import org.junit.Test;

/**
 * @author 武凯焱
 * @date 2019/7/24 9:59
 * @Description:
 */
public class SingleLinkedListTest {
    @Test
    public void add() {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add("cxk" + i);
        }
        System.out.println(singleLinkedList);
    }

    @Test
    public void delete() {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add("cxk" + i);
        }
        singleLinkedList.delete("cxk2");


        System.out.println(singleLinkedList);
    }


    @Test
    public void update() {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add("cxk" + i);
        }
        singleLinkedList.update(8,"sadf");
        singleLinkedList.update(6,"sadf");
        System.out.println(singleLinkedList);
    }

    @Test
    public void contains() {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add("cxk" + i);
        }
        System.out.println(singleLinkedList.contains("cxk"));

    }

    @Test
    public void indexOf() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add("cxk" + i);
        }
    }
    @Test
    public void at(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add("cxk" + i);
        }
        System.out.println(singleLinkedList.at(5));
    }
}
