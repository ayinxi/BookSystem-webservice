package booksystem.dao;

import booksystem.pojo.Book;
import booksystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookDao {

    //获取所有图书
    List<Book> getAllBook();
    //根据商家username获取图书
    List<Book>getBookByShop(String username);
    //根据订单id获取图书
    List<Book>getBookByOrder(String order_id);
    //根据目录名字获取图书
    List<Book>getBookByCategory(String category);
    //根据图书名获取图书
    List<Book>getBookByName(String book_name);
    //根据图书出版社获取图书
    List<Book>getBookByPress(String press);

    //添加
    int addBook(Book book);
    //删除
    int deleteBook(String book_id);
    //更新图书信息
    int updateBook(Book book);
}
