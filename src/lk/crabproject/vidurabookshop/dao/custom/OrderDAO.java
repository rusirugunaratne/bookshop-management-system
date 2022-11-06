/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dao.custom;

import java.util.List;
import lk.crabproject.vidurabookshop.dao.CrudDAO;
import lk.crabproject.vidurabookshop.dao.SuperDAO;
import lk.crabproject.vidurabookshop.dto.OrderDTO;
import lk.crabproject.vidurabookshop.entity.BookDetail;
import lk.crabproject.vidurabookshop.entity.Order;

/**
 *
 * @author DELL
 */
public interface OrderDAO extends CrudDAO<Order, String>{

    public boolean addFullOrder(OrderDTO orderDTO) throws Exception;

    public List<OrderDTO> getOrderDetails() throws Exception;

    public List<BookDetail> getBookOrderDetails() throws Exception;
    
}
