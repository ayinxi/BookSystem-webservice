package booksystem.service;

import booksystem.pojo.Order;

import java.util.List;

public interface OrderService {
    //根据user_id获取所有订单
    List<Order> getAllOrderByUser(String user_id);
    //添加订单
    int addOrder(Order order);
}
