package test;

/**
 * @Author: wky233
 * @Date: 2020/2/6 16:34
 * @Description:
 */
public class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getObjectAddress() {
        return super.toString();
    }

    public static void fun(Dog dog){
        System.out.println(dog); //test.Dog@6f94fa3e
        dog = new Dog("B");
        System.out.println(dog); //test.Dog@5e481248
    }

    public static void main(String[] args) {
        Dog dogA = new Dog("A");
        System.out.println(dogA); // test.Dog@6f94fa3e
        fun(dogA);
        System.out.println(dogA); // test.Dog@6f94fa3e
    }
}
