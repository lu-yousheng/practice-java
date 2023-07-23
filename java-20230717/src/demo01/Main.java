package demo01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyLinklist myLinklist = new MyLinklist();
        //MyLinklist.Node node= myLinklist.creatNode();
        myLinklist.head = myLinklist.creatNode();
        myLinklist.addLast(6);
        myLinklist.addLast(7);
        myLinklist.addFirst(6);
        myLinklist.addIndex(2,8);
        myLinklist.addLast(6);
        //System.out.println(myLinklist.contains(5));
//        myLinklist.dellast();
//        myLinklist.delFirst();
        myLinklist.dispaly();
        //myLinklist.remove(0);
        //myLinklist.removeAll(6);
        System.out.println(myLinklist.size());
        myLinklist.dispaly();
        myLinklist.clear();
        myLinklist.dispaly();

    }
    public static void main5(String[] args) {
        ArrayList<ArrayList<Integer>> three = new ArrayList<>();

    }
    public static void main4(String[] args) {
        String s1 = "welcome bit";
        String s2 = "come";
        ArrayList<Character> arrayList1 = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            arrayList1.add(s1.charAt(i));
        }
        int i = s2.length();
        while (i > 0) {
            //arrayList1.(s2.charAt(i-1));
            i--;
        }
        System.out.println(arrayList1);
    }
    public static void main3(String[] args) {
        MyLinklist myLinklist = new MyLinklist();
        myLinklist.creatNode();
       // myLinklist.dispaly(new MyLinklist.Node());

    }
    public static void main2(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        //System.out.println(arrayList.contains());
        arrayList.set(0,2);
        int ret = arrayList.indexOf(1);
        System.out.println(ret);
        arrayList.dispaly();
    }
    public static void main1(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("我真厉害");
        arrayList.add("java小case！");
        arrayList.add("hhhh");
        //arrayList.add(1,"java真好学");
        arrayList.add("aaa");
        arrayList.add("满了");
        //arrayList.add("aa");
//        arrayList.add("111");
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.addAll(2);
//        int ret = arrayList.remove(2);
        String ret = arrayList.remove(2);
       arrayList.dispaly();
        //System.out.println(ret);
        //arrayList.clear();
        arrayList.set(1,"qaa");
        arrayList.set(4,"aa");
        arrayList.dispaly();
        //System.out.println(arrayList.arr[1]);
    }
}
