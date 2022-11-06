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
import lk.crabproject.vidurabookshop.dao.custom.CustomerDAO;
import lk.crabproject.vidurabookshop.db.DBConnection;
import lk.crabproject.vidurabookshop.dto.CustomerDTO;
import lk.crabproject.vidurabookshop.entity.BookDetail;
import lk.crabproject.vidurabookshop.entity.Customer;

/**
 *
 * @author DELL
 */
public class CustomerDAOImpl implements CustomerDAO{
    
    public  boolean add(Customer customer) throws Exception{
        PreparedStatement stm = DBConnection.getConnection().prepareStatement("Insert into Customer values(?,?,?,?)");
        stm.setObject(1, customer.getCid());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getJoinedDate());
        return stm.executeUpdate()>0;
    }

    public  boolean delete(String cid) throws Exception {
        return DBConnection.getConnection().createStatement().executeUpdate("Delete from Customer where cid ='"+cid+"'")>0;
    }

    public  boolean update(Customer customer) throws Exception {
        PreparedStatement stm = DBConnection.getConnection().prepareStatement("Update customer set name=?, address=?, joinedDate=? where cid=?");
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getJoinedDate());
        stm.setObject(4, customer.getCid());
        return stm.executeUpdate()>0;
    }

    public Customer find(String cid) throws Exception {
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("select * from customer where cid='"+cid+"'");
        if(rst.next()){
        return new Customer(rst.getString("cid"),rst.getString("name"),rst.getString("address"),rst.getString("JoinedDate"));
        }
        return null;
    }

    public  ArrayList<Customer> findAll() throws Exception {
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select * from Customer");
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while(rst.next()){
            allCustomers.add(new Customer(rst.getString("cid"),rst.getString("name"),rst.getString("address"),rst.getString("JoinedDate")));
            
        }
        return allCustomers;
    }

    public ArrayList<String> getIDs() throws Exception {
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select cid from customer");
        ArrayList<String> customerIDs = new ArrayList<>();
        while(rst.next()){
            customerIDs.add(rst.getString("cid"));
        }
        return customerIDs;
    }

    

    

    

    
}
