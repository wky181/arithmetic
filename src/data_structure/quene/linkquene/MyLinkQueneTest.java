package data_structure.quene.linkquene;

/**
 * @author 武凯焱
 * @date 2019/11/7 16:46
 * @Description:
 */
public class MyLinkQueneTest {
    public static void main(String[] args) {
        MyLinkQuene<String> quene = new MyLinkQuene<>();
        quene.enquene("A");
        quene.enquene("B");
        quene.enquene("C");
        quene.enquene("D");
        quene.enquene("E");
        quene.enquene("F");
        System.out.println(quene.dequene());
        System.out.println(quene.getSize());
        System.out.println(quene.peek());

    }
}
