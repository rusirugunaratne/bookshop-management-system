/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.business;

import java.util.List;
import lk.crabproject.vidurabookshop.dao.DAOFactory;
import lk.crabproject.vidurabookshop.dao.custom.OrderDAO;
import lk.crabproject.vidurabookshop.dto.OrderDTO;
import lk.crabproject.vidurabookshop.entity.BookDetail;
import lk.crabproject.vidurabookshop.entity.Order;

/**
 *
 * @author DELL
 */
public class OrderBusiness {
    private static OrderDAO orderDAO= (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    
    public static boolean addOrder(OrderDTO orderDTO) throws Exception{
        return orderDAO.add(new Order(orderDTO.getOrderID(), orderDTO.getCustomerID(), orderDTO.getOrderDate(), orderDTO.getBookDetails()));
    }
    
    public static boolean addFullOrder(OrderDTO orderDTO) throws Exception{
        return orderDAO.addFullOrder(orderDTO);
    }
    
    public static List<OrderDTO> getOrderDetails() throws Exception{
        return orderDAO.getOrderDetails();
    }
    
    public static List<BookDetail> getBookOrderDetails() throws Exception{
        return orderDAO.getBookOrderDetails();
    }
/*
    
    public static boolean deleteCustomer(String cid) throws Exception {
        return customerDAO.delete(cid);
    }

    public static boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.update(new Customer(customer.getCid(),customer.getName(),customer.getAddress(),customer.getJoinedDate()));
    }

    public static CustomerDTO searchCustomer(String cid) throws Exception {
        Customer customer = customerDAO.find(cid);
        return new CustomerDTO(customer.getCid(), customer.getName(), customer.getAddress(), customer.getJoinedDate());
    }

    public static List<CustomerDTO> getAllCustomers() throws Exception {
        List<Customer> allCustomers = customerDAO.findAll();
        List<CustomerDTO> dtoCustomers = new ArrayList<>();
        for (Customer customer : allCustomers) {
            dtoCustomers.add(new CustomerDTO(customer.getCid(), customer.getName(), customer.getAddress(), customer.getJoinedDate()));
        }
        return dtoCustomers;
    }

    public static List<String> getCustomerIDs() throws Exception {
        return customerDAO.getIDs();
    }
*/
}
