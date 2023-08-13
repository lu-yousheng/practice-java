package thread;

public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        //此处创建了一个类实现了Runnable,同时创建了类的实例,并且传给Thread的构造方法

        t.start();
    }
}
