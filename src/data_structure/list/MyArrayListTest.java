package data_structure.list;

/**
 * @author 武凯焱
 * @date 2019/7/23 20:12
 * @Description:
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("cxk" + i);
        }
        String string = list.at(5);
        System.out.println(string);
    }
}
