import java.util.Date;
class Student{
    int age;
    String name;
    public static void func(){
        System.out.println("hello static!");
        Student stu = new Student();
        stu.func1();
    }
    public void func1(){
        System.out.println("hello !");
        func();
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class Base{
    int x;
    int y;

    public Base(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Sub extends Base{
    int z;

    public Sub(int x,int y, int z){
        super(x,y);
        this.z = z;
    }

    public int calculate(){
        return super.x*super.y*z;
    }

    public static void main(String[] args) {
        Sub sub = new Sub(2,2,2);
        System.out.println(sub.calculate());
    }

}
class A{
    public void fun(int x,int y){
        System.out.println(x+y);
    }
    public void fun(double x,double y){
        System.out.println("---");
    }

    public static void main1(String[] args) {
        A a = new A();
    }

}
public class HelloClass {
    public static void main(String[] args) {
        Base base = new Base(10,20);
        Sub sub = (Sub) base;
        System.out.println(sub.calculate());
    }
    public static void main2(String[] args) {
        Student stu = new Student();
        System.out.println(stu);
    }
    public static void main1(String[] args) {
//        Date date = new Date();
//        System.out.println(date.getTime());
//        System.out.println("Hello world!");
        Student.func();
        Student stu = new Student();
        stu.func1();
        //stu.func();
    }
}