package booksystem.dao;

import booksystem.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ShopDao {
    //根据user_id获取店铺信息
    Shop getShopByUser(String user_id);
    //添加一个店铺
    int addShop(Shop shop);
    //根据user_id删除店铺
    int deleteShop(String user_id);
    //修改店铺信息
    int updateShop(Shop shop);
}
