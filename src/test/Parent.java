package test;

/**
 * @Author: wky233
 * @Date: 2020/7/23 16:11
 * @Description:
 */
public abstract class Parent implements Cloneable {
    public String name;
    public int age;

    public Parent() {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract void solve();
    public void method(){
        System.out.println("d");
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
