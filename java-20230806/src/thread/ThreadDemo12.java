package thread;

public class ThreadDemo12 {
    //有三个线程分别只能打印A,B,C.控制是哪个线程固定按照顺序来打印
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Thread t1 = new Thread(()->{
            synchronized (obj1) {
                System.out.println("A");
                obj1.notify();
            }
        });
        Thread t2 = new Thread(()->{;
            synchronized (obj1) {
                try {
                    obj1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("B");
                synchronized (obj2) {
                    obj2.notify();
                }
            }
        });
        Thread t3 = new Thread(()->{
            synchronized (obj2) {
                try {
                    obj2.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("C");
            }
        });
        t2.start();
        t3.start();
        //Thread.sleep(300);
        t1.start();

    }
}
