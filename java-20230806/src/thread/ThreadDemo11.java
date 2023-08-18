package thread;

public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread t1 = new Thread(()->{
            System.out.println("t1:wait之前");
            try {
                synchronized (object) {
                    object.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1:wait之后");
        });

        Thread t2 = new Thread(()->{
            System.out.println("t2:notify之前");
            synchronized (object) {
                object.notify();
            }
            System.out.println("t2:notify之后");
        });
        t1.start();
        Thread.sleep(500);
        t2.start();
    }
}
