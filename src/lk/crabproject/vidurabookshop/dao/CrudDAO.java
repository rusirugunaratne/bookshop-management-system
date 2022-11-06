/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface CrudDAO<T,ID> extends SuperDAO{
    public boolean add(T t) throws  Exception;
    
    public boolean update(T t) throws  Exception;
    
    public T find(ID id) throws  Exception;
    
    public boolean delete(ID id) throws Exception;
    
    public List<T> findAll() throws  Exception;
    
    public List<ID> getIDs() throws Exception;
    
    
    
    
}
