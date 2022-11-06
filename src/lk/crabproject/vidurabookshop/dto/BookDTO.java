/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dto;

/**
 *
 * @author DELL
 */
public class BookDTO {
    private String bid;
    private String name;
    private double price;
    private int qty;

    public BookDTO() {
    }

    public BookDTO(String bid, String name, double price, int qty) {
        this.bid = bid;
        this.name = name;
        this.price = price;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
}
