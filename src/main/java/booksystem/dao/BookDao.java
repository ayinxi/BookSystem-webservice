package booksystem.dao;

import booksystem.pojo.Book;
import booksystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface BookDao {

    //获取所有图书
    HashMap<String,Object> getAllBook();
//    //根据商家username获取图书
//    HashMap<String,Object> getBookByShop(String username);
//    //根据订单id获取图书
//    HashMap<String,Object>getBookByOrder(String order_id);
//    //根据目录名字获取图书
//    HashMap<String,Object>getBookByCategory(String category);
//    //根据图书名获取图书
//    HashMap<String,Object>getBookByName(String book_name);
//    //根据图书出版社获取图书
//    HashMap<String,Object> getBookByPress(String press);

    //添加
    int addBook(Book book);
    //查找用户
    String selectBook( String book_name, String author, double price, String press, String edition, String print_time,String main_category_id,String second_category_id,String shop_id);
    //删除
    int deleteBook(String book_id);
    //更新图书信息
    int updateBook(Book book);

    //根据book_id获取图书
    HashMap<String,Object> getBookByID(String book_id);
}
