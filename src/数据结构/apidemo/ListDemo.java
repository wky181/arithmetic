package 数据结构.apidemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2019/7/27 11:26
 * @Description:
 */
public class ListDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",23));
        list.add(new Student("lisi",46));
        list.add(new Student("zhaowu",39));
        Collections.sort(list,((o1, o2) -> {
            return o1.age - o2.age;
        }));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Student student = (Student) iterator.next();
            System.out.println(student.name);
        }
    }
}

