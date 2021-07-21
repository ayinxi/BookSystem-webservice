package booksystem.service;

import booksystem.pojo.Order;

import java.util.List;

public interface OrderService {
    //获取订单数量
    //根据username获取所有订单
    List<Order> getAllOrderByUser(String username);

    //根据shop_id获取所有订单
    List<Order> getAllOrderByShop(String Shop_id);
    //获取所有订单
    List<Order> getAllOrder();
    //生成订单
    int addOrder(Order order);
}
