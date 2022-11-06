/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.crabproject.vidurabookshop.business;

import java.util.ArrayList;
import java.util.List;
import lk.crabproject.vidurabookshop.dao.DAOFactory;
import lk.crabproject.vidurabookshop.dao.custom.BookDAO;
import lk.crabproject.vidurabookshop.dao.custom.CustomerDAO;
import lk.crabproject.vidurabookshop.dto.BookDTO;
import lk.crabproject.vidurabookshop.dto.CustomerDTO;
import lk.crabproject.vidurabookshop.entity.Book;
import lk.crabproject.vidurabookshop.entity.BookDetail;
import lk.crabproject.vidurabookshop.entity.Customer;

/**
 *
 * @author DELL
 */
public class BookBusiness {
    private static BookDAO bookDAO= (BookDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK);
    
    public static boolean addBook(BookDTO bookDTO) throws Exception{
        return bookDAO.add(new Book(bookDTO.getBid(),bookDTO.getName(),bookDTO.getPrice(),bookDTO.getQty()));
    }

    public static boolean deleteBook(String bid) throws Exception {
        return bookDAO.delete(bid);
    }

    public static boolean updateBook(BookDTO book) throws Exception {
        return bookDAO.update(new Book(book.getBid(),book.getName(),book.getPrice(),book.getQty()));
    }

    public static BookDTO searchBook(String bid) throws Exception {
        Book book = bookDAO.find(bid);
        return new BookDTO(book.getBid(), book.getName(), book.getPrice(), book.getQty());
    }

    public static List<BookDTO> getAllBooks() throws Exception {
        List<Book> allBooks = bookDAO.findAll();
        List<BookDTO> dtoBooks = new ArrayList<>();
        for (Book book : allBooks) {
            dtoBooks.add(new BookDTO(book.getBid(), book.getName(), book.getPrice(), book.getQty()));
        }
        return dtoBooks;
    }

    public static List<String> getBookIDs() throws Exception {
        return bookDAO.getIDs();
    }
    
    public static boolean updateStock(BookDetail bookDetail) throws Exception{
        return bookDAO.updateStock(bookDetail);
    }
    
    public static boolean addBookDetail(BookDetail bookDetail) throws Exception{
        return bookDAO.addBookDetail(bookDetail);
    }
}
