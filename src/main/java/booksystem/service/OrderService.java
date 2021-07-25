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
    int batCancelOrder(List<String> Order_Ids);

    //确认订单
    int firmOrder(String order_id);
    //批量确认订单
    int batFirmOrder(List<String> Order_Ids);

    //订单发货
    int sendOrder(String order_id);
    //批量发货订单
    int batSendOrder(List<String> Order_Ids);

    //同意退款
    int refundOrder(String order_id);
    //批量同意退款
    int batRefundOrder(List<String> Order_Ids);

    //拒绝退款
    int failRefundOrder(String order_id,String check_opinion);
    //批量拒绝退款
    int batFailRefundOrder(Map<String,Object> checkList);

    //用户对某个店铺的评价评价
    int updateRemark(String order_book_id,String remark,double rate);

    //某一个店铺的所有退款订单信息

    //某一个退款订单的详情

    //购物车生成订单
    int addCartItemOrder(List<String> CartItem_Ids,String address_id,String username);
    //直接生成订单
    int addDirectOrder(String book_id, int sum,String address_id,String shop_id,String username);


}
