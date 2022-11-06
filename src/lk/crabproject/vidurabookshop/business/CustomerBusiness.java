/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.crabproject.vidurabookshop.dao.DAOFactory;
import lk.crabproject.vidurabookshop.dao.custom.CustomerDAO;
import lk.crabproject.vidurabookshop.db.DBConnection;
import lk.crabproject.vidurabookshop.dto.CustomerDTO;
import lk.crabproject.vidurabookshop.entity.Customer;

/**
 *
 * @author DELL
 */
public class CustomerBusiness {
    
    private static CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    
    public static boolean addCustomer(CustomerDTO customerDTO) throws Exception{
        return customerDAO.add(new Customer(customerDTO.getCid(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getJoinedDate()));
    }

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
}
