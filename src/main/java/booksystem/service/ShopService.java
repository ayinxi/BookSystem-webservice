package booksystem.service;

import booksystem.pojo.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getShop(int apply_pass1,int apply_pass2,int apply_pass3);
    int getShopNum(int apply_pass);
    //根据user_id获取店铺信息
    Shop getShopByUser(String user_id);
    //店铺注册
    int registerShop();
    //店铺注销 根据user_id删除店铺
    void deleteShop(String user_id);
    //修改店铺信息
    int updateShop(Shop shop);

}
