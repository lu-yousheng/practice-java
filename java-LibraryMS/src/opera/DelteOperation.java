package opera;

import book.BookShelf;

import java.util.Scanner;

public class DelteOperation implements IOperation{
    @Override
    public void work(BookShelf books) {
        if(books.getBookSize() == 0){
            System.out.println("该书架上没有书籍！");
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你要删除的书名！");
        String name = scan.nextLine();
        for (int i = 0; i < books.getBookSize(); i++) {
            if(books.books[i].getName().equals(name)){
                System.out.println(books.books[i]);
                System.out.println("确认删除此书籍？ Y/N");
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("Y")){
                    books.books[i] = null;
                    if(i != books.getBookSize()){
                        for (int j = i; j < books.getBookSize(); j++) {
                            books.books[j] = books.books[j+1];
                        }
                    }
                    books.setBookSize(books.getBookSize()-1);
                    System.out.println("删除成功！");
                }else{
                    System.out.println("取消删除！");
                    return;
                }
            }
        }

    }
}
