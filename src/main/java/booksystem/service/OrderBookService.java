package booksystem.service;

import booksystem.pojo.Book;

import java.util.List;

public interface OrderBookService {

    //根据订单号获取本订单内的所有图书信息
    List<Book> getAllBookByOrder(String order_id);
    //添加一个图书信息
    void addOrderBook(String book_id,String order_id,int number);
}
