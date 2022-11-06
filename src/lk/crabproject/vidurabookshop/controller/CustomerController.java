package lk.crabproject.vidurabookshop.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.crabproject.vidurabookshop.business.CustomerBusiness;
import lk.crabproject.vidurabookshop.db.DBConnection;
import static lk.crabproject.vidurabookshop.db.DBConnection.getConnection;
import lk.crabproject.vidurabookshop.dto.CustomerDTO;
import lk.crabproject.vidurabookshop.entity.Customer;

public class CustomerController {
    public static boolean addCustomer(CustomerDTO customer) throws Exception{
        return CustomerBusiness.addCustomer(customer);
    }

    public static boolean deleteCustomer(String cid) throws Exception {
        return CustomerBusiness.deleteCustomer(cid);
    }

    public static boolean updateCustomer(CustomerDTO customer) throws Exception {
        return CustomerBusiness.updateCustomer(customer);
    }

    public static CustomerDTO searchCustomer(String cid) throws Exception {
        return CustomerBusiness.searchCustomer(cid);
    }

    public static List<CustomerDTO> getAllCustomers() throws Exception {
        return CustomerBusiness.getAllCustomers();
    }

    public static List<String> getCustomerIDs() throws Exception {
        return CustomerBusiness.getCustomerIDs();
    }
}
