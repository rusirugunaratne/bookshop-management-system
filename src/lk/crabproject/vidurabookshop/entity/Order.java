package lk.crabproject.vidurabookshop.entity;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private String customerID;
    private String orderDate;
    private ArrayList<BookDetail> bookDetails;

    /* public Order(String orderID, String customerID, String orderDate) {
    this.orderID = orderID;
    this.customerID = customerID;
    this.orderDate = orderDate;
    }*/

    public Order(String orderID, String customerID, String orderDate) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
    }
    
    

    public Order() {
    }

    public Order(String orderID, String customerID, String orderDate, ArrayList<BookDetail> bookDetails) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.bookDetails = bookDetails;
    }

    public ArrayList<BookDetail> getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(ArrayList<BookDetail> bookDetails) {
        this.bookDetails = bookDetails;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    
}
