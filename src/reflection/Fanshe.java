package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 武凯焱
 * @date 2019/4/14 10:23
 * @Description:
 */
public class Fanshe  {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //第一种方式获取Class对象
        Student student = new Student();//这一new 产生一个Student对象，一个Class对象。
        Class stuClass =  student.getClass();
        System.out.println(stuClass.getName());
        //第二种方式获取Class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
        //第二种方式获取Class对象
        try {
            Class sutClass3 = Class.forName("reflection.Student");
            System.out.println(stuClass2==stuClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] arry = stuClass.getConstructors();
        for (Constructor c: arry) {
            System.out.println(c);
        }
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        arry = stuClass.getDeclaredConstructors();
        for (Constructor c: arry) {
            System.out.println(c);
        }
        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor c = stuClass.getConstructor();
        System.out.println(c);
        c = stuClass.getDeclaredConstructor(char.class);
        System.out.println(c);
        //调用构造方法
        Object obj = c.newInstance();
        //调用构造方法
        c.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = c.newInstance(12);

    }
}
