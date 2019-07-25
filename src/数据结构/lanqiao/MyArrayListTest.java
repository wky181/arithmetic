package 数据结构.lanqiao;

/**
 * @author 武凯焱
 * @date 2019/7/23 20:12
 * @Description:
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("cxk" + i);
        }
        System.out.println(list.toString());
        System.out.println(list.indexOf("cxk10"));
        list.delete(20);
        System.out.println(list.toString());

    }
}
