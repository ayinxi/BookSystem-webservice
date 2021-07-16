package booksystem.service.Impl;

import booksystem.dao.ShopDao;
import booksystem.dao.UserDao;
import booksystem.pojo.Shop;
import booksystem.pojo.User;
import booksystem.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopDao shopDao;
    @Autowired
    UserDao userDao;

    @Override
    public List<Shop> getCheckShop() {
        return shopDao.getApplyShop(2);//2：已审核
    }

    @Override
    public int getCheckShopNum() {
        int num1=shopDao.getShopNum(2,1,1);
        int num2=shopDao.getShopNum(2,2,-1);
        int num3=shopDao.getShopNum(2,-1,2);
        return num1+num2+num3;
    }

    @Override
    public List<Shop> getNonCheckShop() {
        return shopDao.getApplyShop(1);//1:未审核
    }

    @Override
    public int getNonCheckShopNum() {
        return shopDao.getShopNum(1,-1,-1);
    }

    @Override
    public List<Shop> getPassShop() {
        return shopDao.getExistShop(1);//1:未注销
    }

    @Override
    public int getPassShopNum() {
        return shopDao.getShopNum(2,1,1);
    }

    @Override
    public List<Shop> getShopByUser(String username) {
        return shopDao.getShopByUser(username);
    }

    @Override
    public List<Shop> getShopByUserAndStatus(String username, int apply_status, int pass_status, int exist_status) {
        return shopDao.getShopByUserAndStatus(username,apply_status,pass_status,exist_status);
    }

    @Override
    public int registerShop(String username,String shopper_name,String shop_name,String apply_reason) {
        //查找是否有未注销的店铺
        List<Shop> shop1 = shopDao.getShopByUserAndStatus(username, 2, 1, 1);
        if (!shop1.isEmpty())
            return -1;//已有店铺
        //查找是否在审核的店铺

        List<Shop> shop2 = shopDao.getShopByUserAndStatus(username, 1, -1, -1);
        if (!shop2.isEmpty())
            return 2;//已在申请店铺

        User user=userDao.getUserByName(username);
        String user_id=user.getId();
        //apply:1 pass:-1 exsit:-1 已提交未审核、审核状态为无效、存在状态为无效
        Shop shop = new Shop(null, user_id, "http://47.94.131.208:8888/img/original/avatar.jpg", "http://47.94.131.208:8888/img/compression/avatar.jpg",
                shopper_name, shop_name, 5.0, 1, apply_reason, -1, null, -1, null, null);
        shopDao.addShop(shop);

        //检验是否有在未审核的店铺
        if (!shopDao.getShopByUserAndStatus(username, 1, -1, -1).isEmpty())
            return 1;//数据库添加成功
        return 0;//添加失败
    }

//    @Autowired
//    ShopDao shopDao;
//    @Autowired
//    UserDao userDao;
//
//    @Override
//    public List<Shop> getShop(int apply_pass1,int apply_pass2,int apply_pass3) {
//        return shopDao.getShop(apply_pass1,apply_pass2,apply_pass3);
//    }
//
//    @Override
//    public int getShopNum(int apply_pass) {
//        return shopDao.getShopNum(apply_pass);
//    }
//
//    @Override
//    public List<Shop> getShopByUsername(String username) {
//        User user=userDao.getUserByName(username);
//        if(user.getIdentity()==1) {//它是商家
//            return shopDao.getShopByUser(user.getId(),3);//未注销的店铺
//        }else
//        {
//            return null;
//        }
//    }
//
//    @Override
//    public int registerShop(String user_id,String shopper_name,String shop_name,String apply_reason) {
//        List<Shop> shop1=shopDao.getShopByUser(user_id,3);
//        if(!shop1.isEmpty())
//        {
//            return -1;//已有店铺
//        }
//        List<Shop> shop2=shopDao.getShopByUser(user_id,1);
//        if(!shop2.isEmpty())
//        {
//            return 2;//已在申请店铺
//        }
//        Shop shop=new Shop(null,user_id,"http://47.94.131.208:8888/img/original/avatar.jpg","http://47.94.131.208:8888/img/compression/avatar.jpg",
//                shopper_name,shop_name,5.0,1,apply_reason,null,null,null);
//        shopDao.addShop(shop);
//        if(shopDao.getShopByUser(user_id,1)!=null)
//        {
//            return 1;//数据库添加成功
//        }
//        return 0;//添加失败
//    }
//
//
//    @Override
//    public void deleteShop(String user_id) {
//         shopDao.deleteShop(user_id);
//    }
//
//    @Override
//    public int updateShop(Shop shop) {
//        return shopDao.updateShop(shop);
//    }
}
