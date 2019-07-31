package 数据结构.lanqiao.list;

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
        DoubleLinkList doubleLinkList  = new DoubleLinkList();
        for (int i = 0; i < 10 ; i++) {
            doubleLinkList.add("cxk"+i);
        }
        doubleLinkList.delete("cxk0");
        System.out.println(doubleLinkList);
    }


    @Test
    public void update() {
        DoubleLinkList doubleLinkList  = new DoubleLinkList();
        for (int i = 0; i < 10 ; i++) {
            doubleLinkList.add("cxk"+i);
        }
        doubleLinkList.update(5,"wky");
        System.out.println(doubleLinkList);

    }

    @Test
    public void contains() {
        DoubleLinkList doubleLinkList  = new DoubleLinkList();
        for (int i = 0; i < 10 ; i++) {
            doubleLinkList.add("cxk"+i);
        }
        doubleLinkList.delete(5);
        doubleLinkList.update(5,"wky");
        System.out.println(doubleLinkList.contains("wky"));
        System.out.println(doubleLinkList.indexOf("wky"));
        System.out.println(doubleLinkList.at(2));
        System.out.println(doubleLinkList);

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
        //测试迭代器
        DoubleLinkList doubleLinkList  = new DoubleLinkList();
        for (int i = 0; i < 10 ; i++) {
            doubleLinkList.add("cxk"+i);
        }
        while (doubleLinkList.hasNext()){
            System.out.println(doubleLinkList.next());
        }

    }
}
