package opera;

import book.BookShelf;

import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work(BookShelf books) {
        System.out.println("搜索图书！");
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你要搜索的书名！");
        String name = scan.nextLine();
        for (int i = 0; i < books.getBookSize(); i++) {
            if(books.books[i].getName().equals(name)){
                System.out.println(books.books[i]);
                return;
            }
        }
        System.out.println("没有搜索到该图书！");

    }
}
