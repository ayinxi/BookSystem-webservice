package booksystem.service;

import booksystem.pojo.Shop;

import java.util.List;

public interface ShopService {
//    //根据状态获取店铺列表
//    List<Shop> getShop(int apply_pass1,int apply_pass2,int apply_pass3);
//    //获取不同状态的店铺数量
//    int getShopNum(int apply_pass);
//    //根据username获取现有店铺信息
//    List<Shop> getShopByUsername(String username);
//    //店铺注册
//    int registerShop(String user_id,String shopper_name,String shop_name,String apply_reason);
//    //店铺注销 根据user_id删除店铺
//    void deleteShop(String user_id);
//    //修改店铺信息
//    int updateShop(Shop shop);

    //已审核店铺列表
    List<Shop> getCheckShop();
    int getCheckShopNum();
    //未审核店铺列表
    List<Shop> getNonCheckShop();
    int getNonCheckShopNum();
    //未注销店铺列表
    List<Shop> getPassShop();
    int getPassShopNum();

    //通过username查找所有状态的店铺
    List<Shop> getShopByUser(String username);
    //通过username查找特定状态的店铺
    List<Shop> getShopByUserAndStatus(String username,int apply_status,int pass_status,int exist_status);

    //注册账号
    int registerShop(String username,String shopper_name,String shop_name,String apply_reason);

}
