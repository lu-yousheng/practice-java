public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println();
            object.wait();
        }
    }
}
