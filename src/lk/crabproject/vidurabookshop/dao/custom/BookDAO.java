/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.dao.custom;

import lk.crabproject.vidurabookshop.dao.CrudDAO;
import lk.crabproject.vidurabookshop.entity.Book;
import lk.crabproject.vidurabookshop.entity.BookDetail;

/**
 *
 * @author DELL
 */
public interface BookDAO extends CrudDAO<Book, String>{

    public boolean updateStock(BookDetail bookDetail) throws Exception;

    public boolean addBookDetail(BookDetail bookDetail) throws Exception;

    
    
}
