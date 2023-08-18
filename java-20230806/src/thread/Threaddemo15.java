package thread;
//自己写的阻塞队列
class MyBlockingQueue {
    public int[] items = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public void put(int val) {
        if (size == items.length) {
            return;
        }
        items[tail] = val;
        tail++;
        if (tail == items.length) {
            tail = 0;
        }
        size++;
    }
//    public Integer take() {
//        Integer result = items[head];
//        head++;
//    }
}
public class Threaddemo15 {

}
