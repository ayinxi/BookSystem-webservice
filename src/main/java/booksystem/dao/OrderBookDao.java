package booksystem.dao;

import booksystem.pojo.Book;
import booksystem.pojo.OrderBook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderBookDao{
    //根据订单号获取本订单内的所有图书信息
    List<Book> getAllBookByOrder(String order_id);
    //添加一个图书信息
    int addOrderBook(OrderBook orderBook);
}
