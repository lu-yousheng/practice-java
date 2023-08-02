import demo01.MyHeap;

public class Main {
    public static void main(String[] args) {
        MyHeap heap = new MyHeap(5);
        int[] arr = new int[]{1,2,3,4,5};
        heap.initElem(arr);
        heap.shiftDown();
    }
}