package booksystem.service;

import booksystem.pojo.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface OrderBookService {

    //通过order_id获取订单的详细信息
    Map<String,Object> getOrderByOrderID(String order_id);
    //根据username获取所有订单
    List<Map<String,Object>> getAllOrderByUser(String username);
    //根据shop_id获取所有订单
    List<Map<String,Object>> getAllOrderByShop(String shop_id);
    //获取所有的订单
    List<Map<String,Object>> getAllOrder();

    //用户对某本书的评价
    int updateRemark(String order_book_id,String remark,double rate);

    //某本书的退款
    int returnBook(String order_book_id, String return_reason, String return_detail, int transport_status);
    //某本书的换货
    int exchangeBook(String order_book_id,String return_reason,String return_detail,int transport_status);

    //同意退款
    int refundOrder(String order_id);
    //批量同意退款
    int batRefundOrder(List<String> Order_Ids);

    //拒绝退款
    int failRefundOrder(String order_id,String check_opinion);
    //批量拒绝退款
    int batFailRefundOrder(Map<String,Object> checkList);


    //某一个店铺的所有退款订单信息

    //某一个退款订单的详情

    //某一个店铺的所有退款订单信息

    //某一个退款订单的详情
}
