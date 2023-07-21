package demo01;

public class Test<T,Y> {
    T[] obj = (T[])new Object[3];//泛型
    public Object getObj(int pos){
        return obj[pos];
    }

    public void setObj(int p,T val) {
        obj[p] = val;
        return;
    }

    public static void main(String[] args) {
        Test<Integer,Double> test = new Test<>();
        test.setObj(0,12);
        test.setObj(1,13);
        test.setObj(2,12.0);
        

    }
}
