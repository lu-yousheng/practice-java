import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        int[] arry = new int[100];
        int i = 0;
        for (i = 0; i < 100; i++) {
            arry[i] = i+1;
            System.out.println(arry[i]);
        }

    }
    public static int sum1(int num1){
        if(num1 == 1){
            return 1;
        }
        return num1+sum1(num1-1);
    }
    public static void printF(int num){
        if(num <= 0){
            return;
        }
        printF(num/10);
        System.out.println(num%10);
    }
    public static int ret(int num){
        if(num == 1){
            return 1;
        }
        return ret(num-1)*num;
    }
    public static int fib(int key){
        if(key < 3){
            return 1;
        }
        return fib(key-1)+fib(key-2);
    }
    public static void mainer(String[] args) {
        Scanner scan = new Scanner(System.in);
        //int key = scan.nextInt();
        //int num = scan.nextInt();
        //System.out.println(fib(key));
        //System.out.println(ret(num));

        int num1 = scan.nextInt();
        //printF(num1);
        System.out.println(sum1(num1));
    }
    public static void main11(String[] args) {
        double sum = 0;
        double i = 0;
        for(i = 1;i <=100;i++){
            if(i %2 == 0){
                sum -= 1/i;
            }
            else{
                sum += 1/i;
            }
        }
        System.out.println(sum);
    }
    public static void mainz(String[] args) {
        //求一个1-1000之间的水仙花数
//        Scanner scan = new Scanner(System.in);
//        int input = scan.nextInt();
        int k = 1000;
        for(k = 1;k <=1000;k++){
            int input = k;
            int dig = 0;
            int i = 0;
            //求位数
            for(i = input;i > 0; i /= 10){
                dig++;
            }
            //求每个数的次方和
            int tmp = input;
            int sum = 0;
            int j = 0;
            for (j = 0;j < dig;j++){
                sum += Math.pow(tmp%10,dig);
                tmp = tmp/10;
            }
            if(sum == input){
                System.out.println(input);
            }
        }
        }
    public static void main9(String[] args) {
        //输出99乘法表
        int i = 0;
        for(i = 1;i <= 9;i++){
            int j = 0;
            for(j = 1;j <= i;j++){
                System.out.printf(i+"×"+j+"="+i*j+"  / uo");
            }
            System.out.println( );
        }
    }
    public static void main8(String[] args) {
        //判断一个数是否为素数
        //Scanner scan = new Scanner(System.in);
        //int input = scan.nextInt();
       int j = 0;
       for(j = 1; j<=100;j++){
           int input = j;
           int i = 0;
           for (i = 1; i < Math.sqrt(input) ; i++){
               if(input % i == 0 && i != 1){
                   break;
               }
           }
           if(i == Math.sqrt(input)){
               //System.out.printf("%d是素数",input);
               System.out.println(input);
           }
//           else{
//               //System.out.printf("%d不是素数",input);
//           }
       }
    }
    public static void main7(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int a = scan.nextInt();
            System.out.println(a);
        }

    }
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入1：");
        String name = scan.next();
        System.out.println(name);

        System.out.println("请输入2：");
        String name1 = scan.next();
        System.out.println(name1);
    }
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scan.nextLine();
        System.out.println(name);

        System.out.println("请输入年龄：");
        int age = scan.nextInt();
        System.out.println(age);

        System.out.println("请输入你的工资：");
        float f = scan.nextFloat();
        System.out.println(f);

        scan.close();
    }
    public static void mainl(String[] args) {
        int i = 0;
        while(i<=100){
//            if(i%3 == 0 && i%5 == 0){
//                System.out.println(i);
//            }
//            i++;
            if(i%15 != 0){
                i++;
                continue;
            }
                System.out.println(i);
                i++;
        }
    }
    public static void mainr(String[] args) {
        int a = 0;
        while(a<5){
            System.out.println(a);
            a++;
        }
    }
    public static void mainq(String[] args) {
//        short sh =12;
//        sh = (short)(sh + 2);
//        sh +=2;
        int i = 10;
        i++;
        int j = i+1;
        j = j++;
        System.out.println(i);
       System.out.println(j);
    }
    public static void main2(String[] args) {
        String ab = "12321.4";
        //int ret  = Integer.valueOf(ab);
       // double ret1 = Double.valueOf(ab);
        float ret2 = Float.valueOf(ab);
        System.out.println(ret2+1.3);
    }
    public static void main1(String[] args) {
        int a = 10;
        float b = 12.3f;
        //a=b;
        b = a;
        a = (int)b;
        byte ab = 0;
        System.out.println("Hello IDEA!");
    }
}
