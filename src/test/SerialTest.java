package test;

import java.io.*;

/**
 * @Author: wky233
 * @Date: 2020/7/23 17:29
 * @Description:
 */
public class SerialTest implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User dog = new User("d",20);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Serial.txt"));
        oos.writeObject(dog);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Serial.txt"));
        float f = (float) 3.5;


    }


}
