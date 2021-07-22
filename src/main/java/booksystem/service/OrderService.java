package booksystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderService {

    //根据username获取所有订单
    List<Map<String,Object>> getAllOrderByUser(String username);
    //根据shop_id获取所有订单
    List<Map<String,Object>> getAllOrderByShop(String shop_id);
    //获取所有订单
    List<Map<String,Object>> getAllOrder();
    //根据order_id获取
    Map<String,Object> getOrderByID(String order_id);

    //取消订单
    int cancelOrder(String order_id);
    //批量取消订单
    int batCancelOrder(String Order_Ids);

    //购物车生成订单
    int addCartItemOrder(String Book_Ids,String Sum,String address_id,String username);
    //直接生成订单
    int addDirectOrder(String book_id, int sum,String address_id,String shop_id,String username);


}
