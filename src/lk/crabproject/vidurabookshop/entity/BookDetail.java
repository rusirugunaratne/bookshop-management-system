package lk.crabproject.vidurabookshop.entity;
public class BookDetail {
    private String bookCode;
    private String orderID;
    private int qty;
    private double unitPrice;

    public BookDetail() {
    }

    public BookDetail(String bookCode, String orderID, int qty, double unitPrice) {
        this.bookCode = bookCode;
        this.orderID = orderID;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    

    
    
}
