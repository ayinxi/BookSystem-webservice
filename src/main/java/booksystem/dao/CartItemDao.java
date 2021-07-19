package booksystem.dao;

import booksystem.pojo.CartItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
//功能存疑 感觉方法少了又好像够了
public interface CartItemDao {
    //根据user_id来获取购物车信息
    CartItem getCartItem(String user_id);
}
