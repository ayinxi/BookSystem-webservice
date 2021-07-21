package booksystem.service.Impl;

import booksystem.dao.BookDao;
import booksystem.dao.OrderDao;
import booksystem.dao.UserDao;
import booksystem.pojo.Book;
import booksystem.pojo.Order;
import booksystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;

    @Override
    public List<Order> getAllOrderByUser(String user_id) {
        return orderDao.getAllOrderByUser(user_id);
    }

//    @Override
//    public int addOrder(Order order) {
//        return orderDao.addOrder(order);
//    }

    @Override
    public List<Order> getAllOrderByShop(String shop_id) {
        return orderDao.getAllOrderByShop(shop_id);
    }
    @Override
    public List<Order> getAllOrder(){
        return orderDao.getAllOrder();
    }

    @Override
    public int addDirectOrder(String book_id, int sum,String address_id,String shop_id,String username) {
        HashMap<String,Object> book=bookDao.getBookByID(book_id);
        if(sum>Integer.valueOf(book.get("repertory").toString()))
            return -1;//库存不足

        double total=sum*Double.valueOf(book.get("price").toString());
        //订单状态为1 未付款 退款状态为-1 无效
        Order order=new Order(null,total,1,-1,null,null,address_id,shop_id,userDao.getUserByName(username).getId(),null,5.0,null,null);
        orderDao.addOrder(order);
        return 1;
    }
}
