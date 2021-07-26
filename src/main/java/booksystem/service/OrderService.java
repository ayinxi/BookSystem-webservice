package booksystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderService {

    //取消订单
    int cancelOrder(String order_id);
    //批量取消订单
    int batCancelOrder(List<String> Order_Ids);

    //确认订单
    int firmOrder(String order_id);
    //批量确认订单
    int batFirmOrder(List<String> Order_Ids);

    //订单发货
    int sendOrder(String order_id);
    //批量发货订单
    int batSendOrder(List<String> Order_Ids);



    //购物车生成订单
    int addCartItemOrder(List<String> CartItem_Ids,String address_id,String username);
    //直接生成订单
    int addDirectOrder(String book_id, int sum,String address_id,String shop_id,String username);


}
