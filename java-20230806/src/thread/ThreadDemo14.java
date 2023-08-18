package thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadDemo14 {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        //创建两个线程作为生产者和消费者
        Thread customer = new Thread(()->{
            while (true) {
                try {
                    Integer result = blockingQueue.take();
                    System.out.println("消费元素: " + result);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        customer.start();

        Thread producer = new Thread(()->{
            int count = 0;
            while (true) {
                try {
                    blockingQueue.put(count);
                    System.out.println("生产元素: " + count);
                    count++;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();
    }
}
