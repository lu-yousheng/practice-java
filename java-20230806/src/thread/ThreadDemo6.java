package thread;

public class ThreadDemo6 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("helooo");
            }
        },"mythread");
        t.start();
    }
}
