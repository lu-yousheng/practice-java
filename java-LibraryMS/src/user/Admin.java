package user;

import opera.*;

import java.util.Scanner;

public class Admin extends User{
    public Admin(String name) {
        super(name);
        this.operations = new IOperation[]{new EixtOperation(),new ShowOperation(),new FindOperation(),new AddOperation(),
                new DelteOperation(),new ModifyOperation()};
    }
    @Override
    public int menu() {
        System.out.println("***********************");
        System.out.println("欢迎"+name+"来到图书管理系统");
        System.out.println("1：浏览图书");
        System.out.println("2：搜索图书");
        System.out.println("3：增加图书");
        System.out.println("4：删除图书");
        System.out.println("5：修改图书");
        System.out.println("0：退出系统");
        System.out.println("请输入你的选择-》");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;

    }
}
