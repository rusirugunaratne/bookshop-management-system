/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dao;


import lk.crabproject.vidurabookshop.dao.custom.impl.BookDAOImpl;
import lk.crabproject.vidurabookshop.dao.custom.impl.CustomerDAOImpl;
import lk.crabproject.vidurabookshop.dao.custom.impl.OrderDAOImpl;

/**
 *
 * @author DELL
 */
public class DAOFactory {

    private static DAOFactory daoFactory;
    
    public enum DAOTypes{
        CUSTOMER,BOOK,ORDER,ORDER_DETAILS,QUERY
    }

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if (daoFactory == null) {
            daoFactory= new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMER : return new CustomerDAOImpl();
            case BOOK : return new BookDAOImpl();
            case ORDER: return new OrderDAOImpl();
            
            //case QUERY : return new QueryDAOImpl();
            default:return null;
        }
    }
    
}
