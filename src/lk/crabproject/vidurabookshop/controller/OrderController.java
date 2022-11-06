package lk.crabproject.vidurabookshop.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import lk.crabproject.vidurabookshop.business.CustomerBusiness;
import lk.crabproject.vidurabookshop.business.OrderBusiness;
import lk.crabproject.vidurabookshop.db.DBConnection;
import lk.crabproject.vidurabookshop.dto.OrderDTO;
import lk.crabproject.vidurabookshop.entity.Order;


public class OrderController {

    public static String generateOrderID() throws Exception, Exception {
        Connection connection = DBConnection.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM Orders ORDER BY oid DESC LIMIT 1");
        
        if(rst.next()){
            String orderID = rst.getString(1);
            orderID = orderID.split("[A-Z]")[1];
            orderID = (Integer.parseInt(orderID)+1)+"";
            return "D"+orderID;
        }
        return "D1";
    }

    public static boolean addOrder(OrderDTO orderDTO) throws Exception {
        /*PreparedStatement stm = DBConnection.getConnection().prepareStatement("Insert into orders values (?,?,?)");
        Connection connection = DBConnection.getConnection();
        try{
            connection.setAutoCommit(false);
            stm.setObject(1, order.getOrderID());
            stm.setObject(2, order.getCustomerID());
            stm.setObject(3, order.getOrderDate());
            boolean isOrderAdded = stm.executeUpdate()>0;
            if(isOrderAdded){
                boolean isItemsAdded = BookDetailController.addBookDetail(order.getBookDetails());
                if(isItemsAdded){
                    boolean isBookUpdated = BookController.updateStock(order.getBookDetails());
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
        */
        /*
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
        }*/
        
        return OrderBusiness.addFullOrder(orderDTO);
    }
    
}
