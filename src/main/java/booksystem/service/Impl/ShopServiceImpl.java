package booksystem.service.Impl;

import booksystem.dao.ShopDao;
import booksystem.pojo.Shop;
import booksystem.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDao shopDao;

    @Override
    public Shop getShopByUser(String user_id) {
        return shopDao.getShopByUser(user_id);
    }

    @Override
    public int addShop(Shop shop) {
        return shopDao.addShop(shop);
    }

    @Override
    public int deleteShop(String user_id) {
        return shopDao.deleteShop(user_id);
    }

    @Override
    public int updateShop(Shop shop) {
        return shopDao.updateShop(shop);
    }
}
