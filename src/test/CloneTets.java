package test;

/**
 * @Author: wky233
 * @Date: 2020/7/24 11:26
 * @Description:
 */
public class CloneTets {
    public static void main(String[] args) throws CloneNotSupportedException {
        Parent parent = new Parent("jieke",21) {
            @Override
            public void solve() {

            }
        };
        Dog dog = new Dog("tom",20,parent);
        Dog d1 = dog.clone();
        System.out.println(d1.toString());
        System.out.println(dog.parent == d1.parent);
    }
}
