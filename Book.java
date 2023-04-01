public class Book {
    private int Bookcode;
    protected String name;
    protected double price;
    private String author;

    public Book() {
    }
    public Book(String name, double price){
        this.name = name;
        this.price = price;
    }

    public int getBookcode() {
        return Bookcode;
    }

    public void setBookcode(int bookcode) {
        Bookcode = bookcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
