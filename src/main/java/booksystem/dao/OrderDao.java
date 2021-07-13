package booksystem.dao;



import booksystem.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface OrderDao {
    //根据user_id获取所有订单
    List<Order> getAllOrderByUser(String user_id);
    //根据shop_id获取所有订单
    List<Order> getAllOrderByShop(String Shop_id);
    //获取所有订单
    List<Order> getAllOrder();
    //添加订单
    int addOrder(Order order);
}
