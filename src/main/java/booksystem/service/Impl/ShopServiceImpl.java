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
    public List<Shop> getShop(int apply_pass1,int apply_pass2,int apply_pass3) {
        return shopDao.getShop(apply_pass1,apply_pass2,apply_pass3);
    }

    @Override
    public int getShopNum(int apply_pass) {
        return shopDao.getShopNum(apply_pass);
    }

    @Override
    public List<Shop> getShopByUsername(String username) {
        User user=userDao.getUserByName(username);
        if(user.getIdentity()==1) {//它是商家
            return shopDao.getShopByUser(user.getId(),3);//未注销的店铺
        }else
        {
            return null;
        }
    }

    @Override
    public int registerShop(String user_id,String shopper_name,String shop_name,String apply_reason) {
        List<Shop> shop1=shopDao.getShopByUser(user_id,3);
        if(!shop1.isEmpty())
        {
            return -1;//已有店铺
        }
        List<Shop> shop2=shopDao.getShopByUser(user_id,1);
        if(!shop2.isEmpty())
        {
            return 2;//已在申请店铺
        }
        Shop shop=new Shop(null,user_id,"http://47.94.131.208:8888/img/original/avatar.jpg","http://47.94.131.208:8888/img/compression/avatar.jpg",
                shopper_name,shop_name,5.0,1,apply_reason,null,null,null);
        shopDao.addShop(shop);
        if(shopDao.getShopByUser(user_id,1)!=null)
        {
            return 1;//数据库添加成功
        }
        return 0;//添加失败
    }


    @Override
    public void deleteShop(String user_id) {
         shopDao.deleteShop(user_id);
    }

    @Override
    public int updateShop(Shop shop) {
        return shopDao.updateShop(shop);
    }
}
