public class FictionBook extends Book {
    private String category;

    public FictionBook(String category, double price) {
        this.category = category;
        this.price = price;
    }

    public FictionBook() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
