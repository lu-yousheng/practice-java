package thread;

class Counter {
    public int count;
    synchronized public void add() {
        count++;
    }
}
public class ThreadDemo9 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("count = "+counter.count);
    }
}
