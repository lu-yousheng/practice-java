package opera;

import book.BookShelf;

public class ShowOperation implements IOperation{
    @Override
    public void work(BookShelf books) {
        System.out.println("查看图书！");
        for (int i = 0; i < books.getBookSize(); i++) {
            System.out.println(books.books[i]);
        }
    }
}
