package booksystem.service.Impl;

import booksystem.dao.ShopDao;
import booksystem.pojo.Shop;
import booksystem.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDao shopDao;

    @Override
    public List<Shop> getShop(int apply_pass1,int apply_pass2,int apply_pass3) {
        return shopDao.getShop(apply_pass1,apply_pass2,apply_pass3);
    }

    @Override
    public int getShopNum(int apply_pass) {
        return shopDao.getShopNum(apply_pass);
    }

    @Override
    public Shop getShopByUser(String user_id) {
        return shopDao.getShopByUser(user_id);
    }

    @Override
    public int registerShop() {
        return 0;
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
