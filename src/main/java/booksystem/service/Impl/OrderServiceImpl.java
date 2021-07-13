package booksystem.service.Impl;

import booksystem.dao.OrderDao;
import booksystem.pojo.Order;
import booksystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> getAllOrderByUser(String user_id) {
        return orderDao.getAllOrderByUser(user_id);
    }

    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public List<Order> getAllOrderByShop(String shop_id) {
        return orderDao.getAllOrderByShop(shop_id);
    }
    @Override
    public List<Order> getAllOrder(){
        return orderDao.getAllOrder();
    }
}
