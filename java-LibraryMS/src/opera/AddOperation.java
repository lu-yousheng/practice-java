package opera;

import book.Book;
import book.BookShelf;

import java.util.Scanner;

public class AddOperation implements IOperation{
    public void work(BookShelf books) {
        //检查扩容
       if(books.getBookSize() == BookShelf.capacity){
           System.out.println("书架已满！");
       }
        System.out.println("添加图书！");
        Scanner scan  = new Scanner(System.in);
        System.out.println("请输入名字！");
        String name  = scan.nextLine();
        System.out.println("请输入作者！");
        String author = scan.nextLine();
        System.out.println("请输入类型！");
        String type  = scan.nextLine();
        System.out.println("请输入价格");
        int prince = scan.nextInt();

        books.books[books.getBookSize()] = new Book(name,author,type,prince);
        int tmpSize = books.getBookSize()+1;
        books.setBookSize(tmpSize);
    }
}
