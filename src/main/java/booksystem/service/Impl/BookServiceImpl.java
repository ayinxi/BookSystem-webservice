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

    @Override
    public List<Book> getAllBook() {
        return bookDao.getAllBook();
    }

    @Override
    public List<Book> getBookByShop(String username) {
        return bookDao.getBookByShop(username);
    }

    @Override
    public List<Book> getBookByOrder(String order_id) {
        return bookDao.getBookByOrder(order_id);
    }

    @Override
    public List<Book> getBookByCategory(String category) {
        return bookDao.getBookByCategory(category);
    }

    @Override
    public List<Book> getBookByName(String bookname) {
        return bookDao.getBookByName(bookname);
    }

    @Override
    public List<Book> getBookByPress(String press) {
        return bookDao.getBookByPress(press);
    }

    @Override
    public int mutiAddBook(List<Book> book_list) {
        return bookDao.mutiAddBook(book_list);
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBook(String book_id) {
        return bookDao.deleteBook(book_id);
    }

    @Override
    public int mutiDeleteBook(String[] Book_Ids) {
        return bookDao.mutiDeleteBook(Book_Ids);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }
}
