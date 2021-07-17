package booksystem.service;

import booksystem.pojo.Shop;

import java.util.List;

public interface ShopService {

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

    //审核
    int CheckShop(String username,int pass_status,String check_opinion);

    //注销店铺
    int deleteShop(String username);

}
