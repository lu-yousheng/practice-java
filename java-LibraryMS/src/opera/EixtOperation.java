package opera;

import book.BookShelf;

public class EixtOperation implements IOperation{
    @Override
    public void work(BookShelf books) {
        System.out.println("退出系统！");
        System.exit(0);
    }
}
