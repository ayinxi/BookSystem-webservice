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
    List<String> getAllOrderByShop(String shop_id);
    //通过order_id获取订单
    Map<String,Object> getOrderByID(String order_id);

    //status更新
    void updateStatus(int status,String order_id);

    //添加订单
    int addOrder(Order order);

    //时间更新
    void updateFirmTime(String order_id);
    void batUpdateFirmTime(List<String> Order_Ids);
    void updateSendTime(String order_id);
    void batUpdateSendTime(List<String> Order_Ids);

}
