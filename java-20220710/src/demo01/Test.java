package demo01;

import java.util.Arrays;

class Student implements Comparable<Student>{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
//        if(this.age > o.age){
//            return 1;
//        }else if(this.age < o.age){
//            return -1;
//        }else {
//            return 0;
//        }
        if(this.name.compareTo(o.name) > 0){
            return 1;
        }else if(this.name.compareTo(o.name) < 0){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test {
    public void sort(Comparable<Student> stu){

    }
    public static void main(String[] args) {
        Student[] stu = new Student[3];
        stu[0] = new Student("zhangsan",18);
        stu[1] = new Student("lisi",17);
        stu[2] = new Student("wangwu",19);

        //System.out.println(stu[0].compareTo(stu[1]));
        Arrays.sort(stu);
        System.out.println(Arrays.toString(stu));

    }
}
