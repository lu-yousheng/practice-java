package opera;

import book.BookShelf;

import java.util.Scanner;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookShelf books) {
        if (books.getBookSize() == 0){
            System.out.println("当前没有任何图书可借！");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要借阅的书籍名！");
        String name = scanner.nextLine();
        for (int i = 0; i < books.getBookSize(); i++) {
            if(books.books[i].getName().equals(name)){
                System.out.println(books.books[i]);
                System.out.println("确认借阅？");
                String choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("Y")){
                    if(books.books[i].isBorrowed()){
                        System.out.println("该图书已被借出！");
                    }else {
                        books.books[i].setBorrowed(true);
                        System.out.println("借阅成功！");
                        return;
                    }
                }else{
                    System.out.println("取消借阅！");
                    return;
                }
            }
        }

    }
}
