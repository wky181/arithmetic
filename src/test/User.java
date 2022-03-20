package test;

import java.io.Serializable;

/**
 * @Author: wky233
 * @Date: 2020/7/23 20:41
 * @Description:
 */
public class User implements Serializable {
   public String name;
   public static int age;
    public User(String name, int age) {
        this.name = name;
        Dog.age = age;
    }

    @Override
    public  String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "age='" + age + '\'' +
                '}';
    }
}
