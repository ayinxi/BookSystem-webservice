package booksystem.dao;



import booksystem.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OrderDao {
    //根据username获取所有订单
    List<String> getAllOrderByUser(String username);
    //根据shop_id获取所有订单
    List<Map<String,Object>> getAllOrderByShop(String Shop_id);


    //通过order_id获取订单
    Map<String,Object> getOrderByID(String order_id);

    //添加订单
    int addOrder(Order order);
}
