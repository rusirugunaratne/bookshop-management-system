/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dto;

import java.util.ArrayList;
import lk.crabproject.vidurabookshop.entity.BookDetail;

/**
 *
 * @author DELL
 */
public class OrderDTO {
    


    private String orderID;
    private String customerID;
    private String orderDate;
    private ArrayList<BookDetail> bookDetails;

    public OrderDTO(String orderID, String customerID, String orderDate) {
    this.orderID = orderID;
    this.customerID = customerID;
    this.orderDate = orderDate;
    }
    
    

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String customerID, String orderDate, ArrayList<BookDetail> bookDetails) {
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
