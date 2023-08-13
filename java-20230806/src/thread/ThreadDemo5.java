package thread;

public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread  t = new Thread(()->{
            System.out.println("hello");
        });
        t.start();
    }
}
