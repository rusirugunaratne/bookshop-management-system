package lk.crabproject.vidurabookshop.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.crabproject.vidurabookshop.business.BookBusiness;
import lk.crabproject.vidurabookshop.db.DBConnection;
import lk.crabproject.vidurabookshop.dto.BookDTO;
import lk.crabproject.vidurabookshop.entity.Book;
import lk.crabproject.vidurabookshop.entity.BookDetail;

public class BookController {

    public static ArrayList<String> getBookIDs() throws Exception {
        return (ArrayList<String>) BookBusiness.getBookIDs();
        /*ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("select bid from books");
        ArrayList<String> bookIDs = new ArrayList<>();
        while(rst.next()){
        bookIDs.add(rst.getString("bid"));
        }
        return bookIDs;*/
    }

    public static BookDTO searchBook(String bid) throws Exception {
        return BookBusiness.searchBook(bid);
        /*ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select * from Books where bid='"+bid+"'");
        if(rst.next()){
        return new Book(rst.getString("bid"), rst.getString("name"), rst.getDouble("price"), rst.getInt("qtyonhand"));
        }
        return null;*/
    }

    public static boolean updateStock(ArrayList<BookDetail> bookDetails) throws Exception, Exception {
        for (BookDetail bookDetail : bookDetails) {
            boolean updateStock = updateStock(bookDetail);
            if(!updateStock){
                return false;
            }
        }
        return true;
    }
    
    public static boolean updateStock(BookDetail bookDetail) throws Exception, Exception{
        return BookBusiness.updateStock(bookDetail);
        /*PreparedStatement stm = DBConnection.getConnection().prepareStatement("Update Books set qtyOnHand=qtyOnHand-? where bid=?");
        stm.setObject(1, bookDetail.getQty());
        stm.setObject(2, bookDetail.getBookCode());
        return stm.executeUpdate()>0;*/
    }

    public static boolean addBook(BookDTO book) throws Exception {
        return BookBusiness.addBook(book);
        /*PreparedStatement stm = DBConnection.getConnection().prepareStatement("Insert into books values(?,?,?,?)");
        stm.setObject(1, book.getBid());
        stm.setObject(2, book.getName());
        stm.setObject(3, book.getPrice());
        stm.setObject(4, book.getQty());
        return stm.executeUpdate()>0;*/
    }

    public static boolean deleteBook(String bid) throws Exception {
          return DBConnection.getConnection().createStatement().executeUpdate("Delete from Books where bid='"+bid+"'")>0;
    }

    public static boolean updateBook(BookDTO book) throws Exception, Exception {
        return BookBusiness.updateBook(book);
        /*PreparedStatement stm = DBConnection.getConnection().prepareStatement("Update books set name=?, price=?, qtyOnhand=? where bid=?");
        stm.setObject(1, book.getName());
        stm.setObject(2, book.getPrice());
        stm.setObject(3, book.getQty());
        stm.setObject(4, book.getBid());
        return stm.executeUpdate()>0;*/
                
    }

    public static List<BookDTO> getAllBooks() throws Exception {
        return BookBusiness.getAllBooks();
        /*ResultSet rst = DBConnection.getConnection().createStatement().executeQuery("Select * from books");
        ArrayList<Book> books = new ArrayList<>();
        while(rst.next()){
        books.add(new Book(rst.getString("bid"), rst.getString("name"), rst.getDouble("Price"), rst.getInt("qtyonhand")));
        }
        return books;*/
    }
    
}
