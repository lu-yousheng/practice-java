package thread;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run() {
                System.out.println("he;");
            }
        };
        t.start();
    }
}
