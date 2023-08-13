package thread;

public class ThreadDemo8 {
    public static void main(String[] args) {
        //假设当前有两个变量,需要把两个变量各自自增1000w次
        //可以一个线程,先针对a自增,然后对b自增
        //可以两个线程
        //串行
        //serial();
        //并行
        concurrency();
    }

    public static void serial() {
        long beg = System.currentTimeMillis();

        int a = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            a++;
        }
        int b = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - beg)+"ms");
    }
    public static void concurrency() {
        //使用两个线程
        Thread t1 = new Thread(()->{
            long a= 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
               a++;
            }
        });
        Thread t2 = new Thread(()->{
            long b = 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
                b++;
            }
        });
        //开始计时
        long beg = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //结束计时
        long end = System.currentTimeMillis();
        System.out.println("并发执行时间: " + (end-beg) + "ms");
    }
}
