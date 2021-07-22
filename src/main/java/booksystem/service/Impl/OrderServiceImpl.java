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
    public List<Map<String, Object>> getAllOrderByShop(String shop_id) {
        List<String> Order_Ids=orderDao.getAllOrderByShop(shop_id);
        List<Map<String,Object>> mapList=orderBookDao.getAllOrderByShop(Order_Ids);
        return OrderUtils.OrderOutput(mapList);
    }

    @Override
    public List<Map<String, Object>> getAllOrder() {
        List<Map<String, Object>> mapList=orderBookDao.getAllOrder();
        return OrderUtils.OrderOutput(mapList);
    }

    @Override
    public Map<String, Object> getOrderByID(String order_id) {
        List<Map<String, Object>> mapList=orderBookDao.getAllOrder();
        return OrderUtils.OrderOutput(mapList).get(0);
    }

    @Override
    public int cancelOrder(String order_id) {
        List<Map<String,Object>> order=orderBookDao.getOrderByID(order_id);
        if(order.isEmpty())
            return -1;//订单不存在

        //判断取消订单是在 未付款的时候
        if(2==Integer.valueOf(order.get(0).get("status").toString()))
        {
            orderDao.updateStatus(1,order_id);//将状态改为取消订单
            return 1;
        }
        return 0;//处于其他状态不可取消
    }

    @Override
    public int batCancelOrder(String Order_Ids) {
        return 0;
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
            Order order=new Order(order_id,total,2,address_id,shop_id_temp.get(k),userDao.getUserByName(username).getId(),null,null);
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
        //订单状态为2未付款 退款状态为-1 无效
        Order order=new Order(order_id,total,2,address_id,shop_id,userDao.getUserByName(username).getId(),null,null);
        orderDao.addOrder(order);
        OrderBook orderBook=new OrderBook(null,book_id,order_id,sum,null,5.0,-1,null,null);
        orderBookDao.addOrderBook(orderBook);
        return 1;
    }
}
