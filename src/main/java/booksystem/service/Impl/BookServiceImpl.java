package booksystem.service.Impl;

import booksystem.dao.BookDao;
import booksystem.pojo.Book;
import booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

//    @Override
//    public List<Book> getAllBook() {
//        return bookDao.getAllBook();
//    }
//
//    @Override
//    public List<Book> getBookByShop(String username) {
//        return bookDao.getBookByShop(username);
//    }
//
//    @Override
//    public List<Book> getBookByOrder(String order_id) {
//        return bookDao.getBookByOrder(order_id);
//    }
//
//    @Override
//    public List<Book> getBookByCategory(String category) {
//        return bookDao.getBookByCategory(category);
//    }
//
//    @Override
//    public List<Book> getBookByName(String book_name) {
//        return bookDao.getBookByName(book_name);
//    }
//
//    @Override
//    public List<Book> getBookByPress(String press) {
//        return bookDao.getBookByPress(press);
//    }

    @Override
    public int addBook(String book_name, String author, double price, int volume, int repertory, String press, int edition, String print_time, String category_id, String shop_id) {
        Book book=new Book(null,book_name,author,price,volume,repertory,press,edition,print_time,null,null,category_id,shop_id,null,null);
        return bookDao.addBook(book);
    }


    @Override
    public int deleteBook(String book_id) {
        return bookDao.deleteBook(book_id);
    }


    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }
}
