package booksystem.dao;

import booksystem.pojo.Book;
import booksystem.pojo.OrderBook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OrderBookDao{
    //获取所有订单
    List<Map<String,Object>> getAllOrder();

    //通过username获取用户所有订单
    List<Map<String,Object>> getAllOrderByUser(List<String> Order_Ids);

    //通过shop_id获取所有店铺的订单
    List<Map<String,Object>> getAllOrderByShop(List<String> Order_Ids);

    //通过order_id获取一个订单
    List<Map<String,Object>> getOrderByID(String order_id);

    //添加一个图书信息
    int addOrderBook(OrderBook orderBook);
}
