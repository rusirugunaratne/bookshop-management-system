/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.crabproject.vidurabookshop.business.OrderBusiness;
import lk.crabproject.vidurabookshop.controller.BookController;
import lk.crabproject.vidurabookshop.controller.BookDetailController;
import lk.crabproject.vidurabookshop.dao.custom.OrderDAO;
import lk.crabproject.vidurabookshop.db.DBConnection;
import lk.crabproject.vidurabookshop.dto.OrderDTO;
import lk.crabproject.vidurabookshop.entity.BookDetail;
import lk.crabproject.vidurabookshop.entity.Customer;
import lk.crabproject.vidurabookshop.entity.Order;

/**
 *`
 * @author DELL
 */
public class OrderDAOImpl implements OrderDAO{

    @Override
    public boolean add(Order order) throws Exception {
        PreparedStatement stm = DBConnection.getConnection().prepareStatement("Insert into orders values(?,?,?)");
        stm.setObject(1, order.getOrderID());
        stm.setObject(2, order.getCustomerID());
        stm.setObject(3, order.getOrderDate());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(Order t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> findAll() throws Exception {
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select * from Orders");
        ArrayList<Order> allOrders = new ArrayList<>();
        while(rst.next()){
            allOrders.add(new Order(rst.getString("oid"),rst.getString("cid"),rst.getString("orderDate")));
            
        }
        return allOrders;
    }

    @Override
    public List<String> getIDs() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addFullOrder(OrderDTO orderDTO) throws Exception {
        Connection connection = DBConnection.getConnection();
        try{
            connection.setAutoCommit(false);
            boolean isOrderAdded = OrderBusiness.addOrder(orderDTO);
            if(isOrderAdded){
                boolean isItemsAdded = BookDetailController.addBookDetail(orderDTO.getBookDetails());
                if(isItemsAdded){
                    boolean isBookUpdated = BookController.updateStock(orderDTO.getBookDetails());
                    if(isBookUpdated){
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public List<OrderDTO> getOrderDetails() throws Exception {
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select * from Orders");
        ArrayList<OrderDTO> allOrders = new ArrayList<>();
        while(rst.next()){
            allOrders.add(new OrderDTO(rst.getString("oid"),rst.getString("cid"),rst.getString("orderDate")));
            
        }
        return allOrders;
    }

    @Override
    public List<BookDetail> getBookOrderDetails() throws Exception {
        ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select * from BookOrderDetails");
        ArrayList<BookDetail> allOrders = new ArrayList<>();
        while(rst.next()){
            allOrders.add(new BookDetail(rst.getString("oid"),rst.getString("bid"),rst.getInt("qty"),rst.getDouble("unitPrice")));
            
        }
        return allOrders;
    }
    
}
