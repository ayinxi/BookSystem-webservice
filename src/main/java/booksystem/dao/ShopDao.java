package booksystem.dao;

import booksystem.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopDao {
//    List<Shop> getShop(int apply_pass1,int apply_pass2,int apply_pass3);
//    int getShopNum(int apply_pass);
//    //根据user_id获取店铺信息
//    List<Shop> getShopByUser(String user_id,int apply_pass);
//    //添加
//    void addShop(Shop shop);
//    //根据user_id删除店铺
//    void deleteShop(String user_id);
//    //修改店铺信息
//    int updateShop(Shop shop);
//    void updatePass(String user_id,int apply_pass);
//
    //依据apply_status获取店铺
    List<Shop> getApplyShop(int apply_status);
    //依据exist_status获取店铺
    List<Shop> getExistShop(int exist_status);

    //根据三个状态组合来获取店铺数量
    int getShopNum(int apply_status,int pass_status,int exist_status);

    //根据username获取不同申请状态的店铺信息
    List<Shop> getShopByUserAndStatus(String username,int apply_status,int pass_status,int exist_status);
    List<Shop> getShopByUser(String username);

    //添加
    void addShop(Shop shop);

    //更改店铺
    void updateShop(Shop shop);
}
