package thread;
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("hello Runnable");
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        //描述了个任务
        Runnable runnable = new MyRunnable();
        //把任务交给线程执行
        Thread t = new Thread(runnable);
        t.start();
    }
}
