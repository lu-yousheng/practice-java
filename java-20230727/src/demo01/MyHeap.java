package demo01;

public class MyHeap {
    public int[] heap;
    private int useSize;
    public MyHeap(int capacity) {
        this.heap = new int[capacity];
    }

    public void initElem(int[] arry) {
        for (int i = 0; i < arry.length; i++) {
            this.heap[i] = arry[i];
        }
        this.useSize = arry.length;
    }
    public void creatHeap() {

    }
    private void swap(int x,int y) {
        int tmp = 0;
        tmp = x;
        x = y;
        y = tmp;
    }
    public void shiftDown() {
        int child = this.heap.length-1;
        int parent = child/2;
        while (child >= 0) {
            if (child > parent) {
                swap(this.heap[child], this.heap[parent]);
            }
            child--;
            parent = child/2;
        }


    }
}
