package ntu.nguyentruong.vdlamviecsqlite;

public class Book {
    private int id;
    private String name;
    private int pages;

    private  float price;
    private String description;

    public Book(int id, String name, int pages, float price, String description) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.price = price;
        this.description = description;
    }
}
