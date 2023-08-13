package thread;

import java.util.Scanner;

class MyCounter {
    public volatile int flag = 0;
}
public class ThreadDemo10 {
    public static void main(String[] args) {
        MyCounter myCounter = new MyCounter();
        Thread t1 = new Thread(()->{
            while (myCounter.flag == 0) {

            }
            System.out.println("t1循环结束");
        });
        Thread t2 = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数->");
            myCounter.flag = scanner.nextInt();
        });
        t1.start();
        t2.start();
    }
}
