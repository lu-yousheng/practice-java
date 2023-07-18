package book;

public class BookShelf {
    public static final int capacity = 10;
    public  Book[] books = new Book[capacity];
    public int[] arr = new int[10];
    private int bookSize;

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getBookSize() {
        return bookSize;
    }
    public void setBookSize(int bookSize) {
        this.bookSize = bookSize;
    }

}
