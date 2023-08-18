package thread;

//饿汉模式的单例模式
//此处保证sigleton这个类只能创建出一个实例
class Singleton {
    //在此处,先把这个实例给创建出来了.
    private static Singleton instance = new Singleton();

    //统一通过这个方法获取这个实例
    public static Singleton getInstance() {
        return instance;
    }
    //为零避免这个类不小心被复制出多份来
    //把构造方法设为private.在类外卖就无法通过new的方式来创建这个对象的实例了
    private Singleton() {};
}
class Singletonlazy {
    private volatile static Singletonlazy instance = null;
    public  static Singletonlazy getInstance() {
        if (instance == null) {
            synchronized (Singletonlazy.class) {
                if (instance == null) {
                    instance = new Singletonlazy();
                }
                return instance;
            }
        }
        return instance;
    }
    private Singletonlazy() {};
}
public class ThreadDemo13 {
    public static void main(String[] args) {
        Singletonlazy s = Singletonlazy.getInstance();
        Singletonlazy s2 = Singletonlazy.getInstance();
        System.out.println(s == s2);
    }
    public static void main1(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s == s2);//确认该类只能创建一个实例
    }
}
