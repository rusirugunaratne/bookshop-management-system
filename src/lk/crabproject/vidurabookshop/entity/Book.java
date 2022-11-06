package lk.crabproject.vidurabookshop.entity;
public class Book {
    private String bid;
    private String name;
    private double price;
    private int qty;

    public Book() {
    }

    
    
    public Book(String bid, String name, double price, int qty) {
        this.bid = bid;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
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
    
    
}
