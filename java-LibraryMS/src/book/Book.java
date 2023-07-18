package book;

public class Book {
    private String name;
    private String author;
    private String type;
    private int price;
    private boolean isBorrowed;

    public Book(String name, String author, String type, int price) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", isBorrowed=" + isBorrowed(isBorrowed()) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthotr() {
        return author;
    }

    public void setAuthotr(String authotr) {
        this.author = authotr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    public String isBorrowed(boolean isBorrow){
        if(isBorrow){
            return "已借出";
        }else {
            return "未借出";
        }
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
