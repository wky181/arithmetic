package tensorts;

/**
 * @Author: wky233
 * @Date: 2020/8/14 10:53
 * @Description:
 */
public class PrintAB {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

}

class Number implements Runnable {
    private int number = 1;
    private Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                lock.notify();
                if (number <= 100) {
                    /*try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } else {
                    break;
                }
            }
        }
    }
}