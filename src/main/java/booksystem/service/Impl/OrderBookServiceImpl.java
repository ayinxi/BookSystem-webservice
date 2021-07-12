package booksystem.service.Impl;

import booksystem.dao.OrderBookDao;
import booksystem.pojo.Book;
import booksystem.pojo.Order_Book;
import booksystem.service.OrderBookService;
import booksystem.service.OrderService;
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
    public int addOrderBook(Order_Book orderBook) {
        return orderBookDao.addOrderBook(orderBook);
    }
}
