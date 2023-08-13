package thread;

class MyThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //System.out.println("hello world");
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        //创建线程
        Thread t = new MyThread();//属于java.lang包下面的类不需要导包
        t.start();//启动一个线程--线程的一个特殊方法
        // start是创建了个新线程,新的线程负责执行t.run
        while (true) {
            System.out.println("hello main");
            //让打印速度变慢
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
