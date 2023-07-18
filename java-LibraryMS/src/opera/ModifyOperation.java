package opera;

import book.Book;
import book.BookShelf;

import java.util.Scanner;

public class ModifyOperation implements IOperation{
    @Override
    public void work(BookShelf books) {
        if (books == null){
            return;
        }
        if (books.getBookSize() == 0){
            System.out.println("你的书架没有任何图书！");
            return;
        }
        System.out.println("请输入你要修改的图书！");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for (int i = 0; i < books.getBookSize(); i++) {
            if(books.books[i].getName().equals(name)){
                System.out.println(books.books[i]);
                System.out.println("修改图书！");
                System.out.println("请输入名字！");
                String name1  = scan.nextLine();
                System.out.println("请输入作者！");
                String author = scan.nextLine();
                System.out.println("请输入类型！");
                String type  = scan.nextLine();
                System.out.println("请输入价格");
                int prince = scan.nextInt();
                books.books[i] = null;
                books.books[i] = new Book(name1,author,type,prince);
                System.out.println("修改成功！");
                return;
            }
        }
        System.out.println("你要修改的图书不存在！");
    }
}
