package tensorts;

/**
 * @Author: wky233
 * @Date: 2020/8/14 16:09
 * @Description:
 */
public class PrintABC {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);

        new Thread(pa).start();
        try {
            Thread.sleep(10);// 保证初始ABC的启动顺序
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(pb).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(pc).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class ThreadPrinter implements Runnable{
    private String name;
    private Object prev;
    private Object self;
    public ThreadPrinter(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }
    @Override
    public void run() {
       int count = 10;
       while (count > 0){
           synchronized (prev){
               synchronized (self){
                   System.out.println(Thread.currentThread().getName() + " " + name);
                   count--;
                   self.notify();
               }
               if (count == 0){
                   prev.notify();
               }else {
                   try {
                       prev.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
    }
}