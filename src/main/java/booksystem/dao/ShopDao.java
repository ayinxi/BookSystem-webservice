package booksystem.dao;

import booksystem.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopDao {
    List<Shop> getShop(int apply_pass1,int apply_pass2,int apply_pass3);
    int getShopNum(int apply_pass);
    //根据user_id获取店铺信息
    Shop getShopByUser(String user_id);
    //添加
    void addShop(Shop shop);
    //根据user_id删除店铺
    void deleteShop(String user_id);
    //修改店铺信息
    int updateShop(Shop shop);
    void updatePass(String user_id,int apply_pass);
}
