package opera;

import book.BookShelf;

import java.util.Scanner;

public class BankOperation implements IOperation{
    @Override
    public void work(BookShelf books) {
        System.out.println("请输入你要归还的书籍名！");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for (int i = 0; i < books.getBookSize(); i++) {
            if(books.books[i].getName().equals(name)){
                if(books.books[i].isBorrowed()){
                    System.out.println("确认归还？");
                    String choice = scan.nextLine();
                    if(choice.equalsIgnoreCase("Y")){
                        books.books[i].setBorrowed(false);
                        System.out.println("归还成功！");
                        return;
                    }else{
                        System.out.println("取消归还！");
                        return;
                    }
                }else {
                    System.out.println("该书籍未被借出！");
                    return;
                }
            }
        }
    }
}
