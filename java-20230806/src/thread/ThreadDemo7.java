package thread;

public class ThreadDemo7 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                //
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //启动之前获取t的状态
        System.out.println("start之前: " + t.getState());
        t.start();
        try {
            System.out.println(t.getState());
            t.join();
            System.out.println(t.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("t结束之后: " + t.getState());
    }
}
