package 数据结构.lanqiao;

import org.junit.Test;

/**
 * @author 武凯焱
 * @date 2019/7/25 11:08
 * @Description:
 */
public class DoubleLinkListTest {
    @Test
    public void add() {
       DoubleLinkList doubleLinkList  = new DoubleLinkList();
        for (int i = 0; i <10 ; i++) {
            doubleLinkList.add("cxk"+i);
        }
        System.out.println(doubleLinkList);
}

    @Test
    public void delete() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add("cxk" + i);
        }
        singleLinkedList.delete(0);
        singleLinkedList.delete(2);

        System.out.println(singleLinkedList);
    }


    @Test
    public void update() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            singleLinkedList.add("cxk" + i);
        }
        singleLinkedList.update(8,"sadf");
        singleLinkedList.update(6,"sadf");
        System.out.println(singleLinkedList);
    }

    @Test
    public void contains() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
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
