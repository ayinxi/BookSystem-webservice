package booksystem.service.Impl;

import booksystem.dao.BookDao;
import booksystem.pojo.Book;
import booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

//    @Override
    public Map<String,Object> getAllBook() {
        return bookDao.getAllBook();
    }

    @Override
    public int addBook(String book_name, String author, double price, int repertory, String press, String edition, String print_time, String main_category_id, String second_category_id, String shop_id) {
        Book book=new Book(null,book_name,author,price,0,repertory,press,edition,print_time,"null","null",main_category_id,second_category_id,shop_id,null,null);
        return bookDao.addBook(book);
    }

    @Override
    public String selectBook(String book_name, String author, double price, String press, String edition, String print_time, String main_category_id, String second_category_id, String shop_id) {
        return bookDao.selectBook(book_name,author,price,press,edition,print_time,main_category_id,second_category_id,shop_id);
    }
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
    public int deleteBook(String book_id) {
        return bookDao.deleteBook(book_id);
    }


    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }
}
