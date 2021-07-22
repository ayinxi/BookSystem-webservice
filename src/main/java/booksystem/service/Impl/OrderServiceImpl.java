package booksystem.service.Impl;

import booksystem.dao.BookDao;
import booksystem.dao.OrderBookDao;
import booksystem.dao.OrderDao;
import booksystem.dao.UserDao;
import booksystem.pojo.Order;
import booksystem.pojo.OrderBook;
import booksystem.service.CartItemService;
import booksystem.service.OrderService;
import booksystem.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;
    @Autowired
    OrderBookDao orderBookDao;
    @Autowired
    CartItemService cartItemDao;



    @Override
    public List<Map<String, Object>> getAllOrderByUser(String username) {
        List<String> Order_Ids=orderDao.getAllOrderByUser(username);
        List<Map<String,Object>> mapList=orderBookDao.getAllOrderByUser(Order_Ids);
        return OrderUtils.OrderOutput(mapList);
    }

    @Override
    public List<Map<String, Object>> getAllOrderByShop(String Shop_id) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getAllOrder() {
        List<Map<String, Object>> mapList=orderBookDao.getAllOrder();
        return OrderUtils.OrderOutput(mapList);
    }

    @Override
    public HashMap<String, Object> getOrderByID() {
        return null;
    }

    @Override
    public int addCartItemOrder(String Book_Ids, String Sums, String address_id, String username) {
        //获取订单中书的id和数量
        String[] ids=Book_Ids.split(",");
        String[] Sum=Sums.split(",");

        String[] shop_ids=new String[ids.length];
        int[] sums=new int[ids.length];
        double[] price=new double[ids.length];
        List<OrderBook> orderBookList=new ArrayList<OrderBook>();
        OrderBook orderBook=null;

        //切割 分成order_book项
        for( int j=0;j<ids.length;j++) {
            String book_id=ids[j];
            sums[j]=Integer.valueOf(Sum[j]);
            HashMap<String,Object> book=bookDao.getBookByID(book_id);
            shop_ids[j]=book.get("shop_id").toString();
            price[j]=Double.valueOf(book.get("price").toString());

            //检查库存
            int repertory=Integer.valueOf(book.get("repertory").toString());
            if(sums[j]>repertory)
                return -1;//库存不足

            orderBook=new OrderBook(null,book_id,null,sums[j],null,5.0,-1,null,null);
            orderBookList.add(j,orderBook);
        }

        //去重 得到不重复的shop_id
        Set shopIdsSet=new HashSet();
        List<String> shop_id_temp=new ArrayList<String>();
        for(String shop_id:shop_ids)
        {
            if(shopIdsSet.add(shop_id))
                shop_id_temp.add(shop_id);
        }

        //根据shop_id形成订单
        for(int k=0;k<shop_id_temp.size();k++) //订单的数量
        {
            //计算总价
            double total=0;
            //生成order_id
            String order_id=String.valueOf(UUID.randomUUID()).replace("-","").toString().toLowerCase();

            //查找统一订单的图书
            for (int i = 0; i < ids.length; i++)
            {
                //是同一家店
                if (shop_id_temp.get(k).equals(shop_ids[i])) {
                    orderBookList.get(i).setOrder_id(order_id);
                    orderBookDao.addOrderBook(orderBookList.get(i));
                    //更改库存
//                    bookDao.updateRepertory(ids[i],repertory-sum);
                    total+=sums[i]*price[i];
                    //删除购物车的东西
                    cartItemDao.deleteCartItem(ids[i], username);
                }
            }
            Order order=new Order(order_id,total,1,address_id,shop_id_temp.get(k),userDao.getUserByName(username).getId(),null,null);
            orderDao.addOrder(order);
        }
        return 1;
    }

    @Override
    public int addDirectOrder(String book_id, int sum,String address_id,String shop_id,String username) {
        HashMap<String,Object> book=bookDao.getBookByID(book_id);
        int repertory=Integer.valueOf(book.get("repertory").toString());
        if(sum>repertory)
            return -1;//库存不足
        //更改库存
        //bookDao.updateRepertory(book_id,repertory-sum);
        String order_id=String.valueOf(UUID.randomUUID()).replace("-","").toString().toLowerCase();
        double total=sum*Double.valueOf(book.get("price").toString());
        //订单状态为1未付款 退款状态为-1 无效
        Order order=new Order(order_id,total,1,address_id,shop_id,userDao.getUserByName(username).getId(),null,null);
        orderDao.addOrder(order);
        OrderBook orderBook=new OrderBook(null,book_id,order_id,sum,null,5.0,-1,null,null);
        orderBookDao.addOrderBook(orderBook);
        return 1;
    }
}
