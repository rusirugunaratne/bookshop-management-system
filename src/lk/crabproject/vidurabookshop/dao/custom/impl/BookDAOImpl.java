/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dao.custom.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.crabproject.vidurabookshop.dao.custom.BookDAO;
import lk.crabproject.vidurabookshop.db.DBConnection;
import lk.crabproject.vidurabookshop.entity.Book;
import lk.crabproject.vidurabookshop.entity.BookDetail;
import lk.crabproject.vidurabookshop.entity.Customer;

/**
 *
 * @author DELL
 */
public class BookDAOImpl implements BookDAO{

    @Override
    public boolean add(Book book) throws Exception {
        PreparedStatement stm = DBConnection.getConnection().prepareStatement("Insert into Books values(?,?,?,?)");
        stm.setObject(1, book.getBid());
        stm.setObject(2, book.getName());
        stm.setObject(3, book.getPrice());
        stm.setObject(4, book.getQty());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(Book book) throws Exception {
        PreparedStatement stm = DBConnection.getConnection().prepareStatement("Update Books set name=?, price=?, qtyonhand=? where cid=?");
        stm.setObject(1, book.getName());
        stm.setObject(2, book.getPrice());
        stm.setObject(3, book.getQty());
        stm.setObject(4, book.getBid());
        return stm.executeUpdate()>0;
    }

    @Override
    public Book find(String bid) throws Exception {
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("select * from Books where bid='"+bid+"'");
        if(rst.next()){
        return new Book(rst.getString("bid"),rst.getString("name"),rst.getDouble("price"),rst.getInt("qtyOnhand"));
        }
        return null;
        
    }

    @Override
    public boolean delete(String bid) throws Exception {
        return DBConnection.getConnection().createStatement().executeUpdate("Delete from Books where cid ='"+bid+"'")>0;
    }

    @Override
    public List<Book> findAll() throws Exception {
        
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select * from Books");
        ArrayList<Book> allBooks = new ArrayList<>();
        while(rst.next()){
            allBooks.add(new Book(rst.getString("bid"),rst.getString("name"),rst.getDouble("price"),rst.getInt("qtyonhand")));
            
        }
        return allBooks;
    }

    @Override
    public List<String> getIDs() throws Exception {
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select bid from Books");
        ArrayList<String> BookIDs = new ArrayList<>();
        while(rst.next()){
            BookIDs.add(rst.getString("bid"));
        }
        return BookIDs;
    }

    @Override
    public boolean updateStock(BookDetail bookDetail) throws Exception {
        PreparedStatement stm = DBConnection.getConnection().prepareStatement("Update Books set qtyOnHand=qtyOnHand-? where bid=?");
        stm.setObject(1, bookDetail.getQty());
        stm.setObject(2, bookDetail.getBookCode());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean addBookDetail(BookDetail bookDetail) throws Exception {
        PreparedStatement stm = DBConnection.getConnection().prepareStatement("Insert into BookOrderDetails values(?,?,?,?)");
        stm.setObject(1, bookDetail.getOrderID());
        stm.setObject(2, bookDetail.getBookCode());
        stm.setObject(3, bookDetail.getQty());
        stm.setObject(4, bookDetail.getUnitPrice());
        return stm.executeUpdate()>0;
    }
    
    
}
