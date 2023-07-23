package demo01;

public class MyLinklist {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node head;
    public Node creatNode() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        this.head  = n1;
        return head;
    }
    //尾插法
    public void addLast(int data) {
        Node newdata = new Node(data);
        if (this.head == null) {
            this.head = newdata;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newdata;
    }
    //头插法
    public void addFirst(int data) {
        Node newdata = new Node(data);
        if (this.head == null) {
            this.head = newdata;
        }
        newdata.next = this.head;
        this.head = newdata;
    }

    //打印
    public void dispaly() {
        if (this.head == null) {
            return;
        }
        Node cur = this.head;
        System.out.print("[");
        while (cur != null) {
            if (cur.next != null){
                 System.out.print(cur.val+ ",");
            }else {
            System.out.print(cur.val);
            }
            cur = cur.next;
        }
        System.out.print("]");
        System.out.println();
    }

    //在任意位置插入数据
    public void addIndex(int index,int data) {
        if (this.head == null) {
            return;
        }
        Node newdata = new Node(data);
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.val == index) {
                newdata.next = cur.next;
                cur.next = newdata;
                return;
            }
            cur = cur.next;
        }

    }

    //查询是否有关键字在链表中
    public boolean contains(int val) {
        if (this.head == null) {
            return false;
        }
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.val == val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //头删
    public void delFirst() {
        if (this.head == null) {
            return;
        }
        Node newHead = this.head;
        this.head = this.head.next;
        newHead = null;
    }
    //尾删
    public void dellast() {
        if (this.head == null) {
            return;
        }
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        Node newLast = cur.next;
        cur.next = null;
        newLast = null;
    }
    //删除第一个关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.val == key) {
            delFirst();
        }
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.val == key && cur.next.next == null) {
                dellast();
                break;
            } else if (cur.next.val == key) {
                cur.next =cur.next.next;
                break;
            }
            cur = cur.next;
        }

        return;
    }
    //删除所有key的节点
    public void removeAll(int key) {
        if (this.head == null) {
            return;
        }
        Node cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                remove(key);
            }
            cur = cur.next;
        }
        return;
    }

    //得到单链表的长度
    public int size() {
        if (this.head == null) {
            return 0;
        }
        int count = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    public void clear() {
        if (this.head == null) {
            return;
        }
        while (head != null) {
            head = head.next;
        }
    }
}
