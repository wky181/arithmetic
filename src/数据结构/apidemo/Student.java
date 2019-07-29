package 数据结构.apidemo;

/**
 * @author 武凯焱
 * @date 2019/7/27 10:27
 * @Description:
 */
public class Student implements Comparable {
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name ;
    int age;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
