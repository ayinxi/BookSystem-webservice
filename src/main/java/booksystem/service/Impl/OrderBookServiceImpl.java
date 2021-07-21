package booksystem.service.Impl;

import booksystem.dao.OrderBookDao;
import booksystem.pojo.Book;
import booksystem.pojo.OrderBook;
import booksystem.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderBookServiceImpl implements OrderBookService {
    @Autowired
    OrderBookDao orderBookDao;


    @Override
    public List<Book> getAllBookByOrder(String order_id) {
        return orderBookDao.getAllBookByOrder(order_id);
    }

    @Override
    public void addOrderBook(String book_id,String order_id, int number) {
        OrderBook orderBook=new OrderBook(null,book_id,order_id,number,null,null);
    }

}
