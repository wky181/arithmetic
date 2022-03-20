package test;

import java.io.Serializable;

/**
 * @Author: wky233
 * @Date: 2020/2/6 16:34
 * @Description:
 */
public class Dog extends Parent implements Serializable ,Cloneable  {
    String name;
    static int age;
    Parent parent;

    Dog(String name, int age, Parent parent) {
        this.name = name;
        Dog.age = age;
        this.parent = parent;
    }

    @Override
    protected Dog clone() throws CloneNotSupportedException {
        Dog dog  = (Dog) super.clone();
        dog.parent = (Parent) parent.clone();
        return dog;
    }

    @Override
    public void solve() {
        super.method();
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }

    String getObjectAddress() {
        return super.toString();
    }

  /*  public static void fun(Dog dog){
        System.out.println(dog); //test.Dog@6f94fa3e
        dog = new Dog("B");
        System.out.println(dog); //test.Dog@5e481248
    }

    public static void main(String[] args) {
        Dog dogA = new Dog("A");
        System.out.println(dogA); // test.Dog@6f94fa3e
        fun(dogA);
        System.out.println(dogA); // test.Dog@6f94fa3e
    }*/
}
