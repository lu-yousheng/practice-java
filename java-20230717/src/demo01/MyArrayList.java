package demo01;

import java.util.Collection;

public class MyArrayList<E> {
    public E[] arr;
    public int pos;
    public static final int init = 5;

    public MyArrayList() {

        this.arr = (E[]) new Object[init];
    }

    //判断位置是否合法
    private boolean isLegal(int index) {
        if((index < 0) && (index > init)) {
            return false;
        }
        return true;
    }

    //尾插数据
    public boolean add(E e){
        if(this.pos == init) {
            //扩容
            System.out.println("容量已满！");
            return false;
        }
        arr[pos] = e;
        this.pos++;
        return true;
    }

    //添加指定位置数据
    public void add(int index, E element) {
        if (this.pos == init ) {
            System.out.println("容量已满！");
            return;
        }
        if(isLegal(index)) {
            if (index < this.pos ) {
                int i = this.pos;
                while (i >= index) {
                    arr[i+1] = arr[i] ;
                    i--;
                }
                arr[index] = element;
                this.pos++;
            }else {
                add(element);
            }
        }
        return;
    }

    //打印
    public void dispaly(){
        System.out.print("[");
        for (int i = 0; i < this.pos; i++) {
            System.out.print(arr[i]);
            if (i < this.pos-1) {
                System.out.print(" ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
    //尾插数据
    public boolean addAll(E element) {
        if(this.pos == init) {
            System.out.println("容量已满！");
            return false;
        }
        arr[this.pos] = element;
        this.pos++;
        return true;
    }

    //private int findPos(int)

    //移除指定位置元素
     public E remove(int index) {
        if (this.pos == 0) {
            System.out.println("当前表中没有元素！");
            return null;
        }
        if (isLegal(index)) {
            E tmp = arr[index];
            if (index == this.pos-1) {
                this.arr[index] = null;
            } else {
                while (index < this.pos-1) {
                    arr[index] = arr[index+1];
                    index++;
                }
            }
            this.pos--;
            return tmp;
        }
        return null;
    }
    //获取下标元素
    public E get(int index) {
        if (this.pos == 0) {
            return null;
        }
        if (isLegal(index)) {
            return arr[index];
        } else {
            System.out.println("坐标不合法！");
            return null;
        }
    }
    //将下标 index 位置元素设置为 element
    public E set(int index, E element) {
        if (this.pos == 0) {
            return null;
        }
        if (isLegal(index)) {
            arr[index] = element;
            return arr[index];
        }
        return null;
    }
    //判断 o 是否在线性表中
    public boolean contains(E o) {
        if (this.pos == 0) {
            return false;
        }
        for (int i = 0; i < this.pos; i++) {
            if (arr[i] == o) {
                return true;
            }
        }
        return false;
    }
    //返回第一个 o 所在下标
    public int indexOf(Object o) {
        if (this.pos == 0) {
            return -1;
        }
        for (int i = 0; i < this.pos; i++) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
    //返回最后一个 o 的下标
    public int lastIndexOf(Object o) {
        if (this.pos == 0) {
            return -1;
        }
        for (int i = this.pos-1; i >= 0 ; i++) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }
    //清空
    public void clear() {
        if (this.pos == 0) {
            return;
        }
        for (int i = 0; i < this.pos; i++) {
            arr[i] = null;
        }
        this.pos = 0;
        return;
    }
}
