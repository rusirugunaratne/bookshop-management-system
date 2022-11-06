package lk.crabproject.vidurabookshop.controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.crabproject.vidurabookshop.business.BookBusiness;
import lk.crabproject.vidurabookshop.db.DBConnection;
import lk.crabproject.vidurabookshop.entity.BookDetail;

public class BookDetailController {

    public static boolean addBookDetail(ArrayList<BookDetail> bookDetails) throws Exception, Exception {
        for (BookDetail bookDetail : bookDetails) {
            boolean addBookDetail = addBookDetail(bookDetail);
            if(!addBookDetail){
                return false;
            }
        }
        return true;
    }
    
    public static boolean addBookDetail(BookDetail bookDetail) throws Exception, Exception{
        return BookBusiness.addBookDetail(bookDetail);
        /*PreparedStatement stm = DBConnection.getConnection().prepareStatement("Insert into BookOrderDetails values(?,?,?,?)");
        stm.setObject(1, bookDetail.getOrderID());
        stm.setObject(2, bookDetail.getBookCode());
        stm.setObject(3, bookDetail.getQty());
        stm.setObject(4, bookDetail.getUnitPrice());
        return stm.executeUpdate()>0;*/
    }
    
}
