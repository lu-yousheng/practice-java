
import book.Book;
import book.BookShelf;
import opera.IOperation;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static User login(){
        System.out.println("欢迎来到图书管理系统！");
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你的姓名-》");
        String name = scan.nextLine();
        System.out.println("请输入你的身份 -》1.管理员 0.用户");
        int choice = scan.nextInt();
        if(choice == 1){
            return new Admin(name);
        }else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        User user = login();
        BookShelf bookShelf = new BookShelf();
        bookShelf.books[0] = new Book("三国演义","罗贯中","小说",10);
        bookShelf.books[1] = new Book("西游记", "吴承恩","小说",16);
        bookShelf.books[2] = new Book("红楼梦","moyuz","小说",13);
        bookShelf.setBookSize(3);
        while (true){
            int choice = user.menu();
            user.operations[choice].work(bookShelf);
        }
    }
}
