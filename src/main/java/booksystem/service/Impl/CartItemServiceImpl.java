package booksystem.service.Impl;

import booksystem.dao.BookDao;
import booksystem.dao.CartItemDao;
import booksystem.dao.ShopDao;
import booksystem.dao.UserDao;
import booksystem.pojo.Shop;
import booksystem.pojo.User;
import booksystem.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartItemServiceImpl implements CartItemService {
        @Autowired
        CartItemDao cartItemDao;
        @Autowired
        BookDao bookDao;
        @Autowired
        ShopDao shopDao;
        @Autowired
        UserDao userDao;

        @Override
        public List<Map<String,Object>> getCartItem(String username) {
                List<Map<String,Object>> mapList=cartItemDao.getCartItem(username);
                if(mapList.isEmpty())
                        return null;
                for(Map<String,Object> map:mapList)
                {
                        String book_id=map.get("book_id").toString();
                        String shop_id=bookDao.getBookByID(book_id).get("shop_id").toString();
                        Shop shop= shopDao.getShopById(shop_id);
                        String shop_name=shop.getShop_name();
                        map.put("shop_name",shop_name);
                }


                return mapList;
        }

        @Override
        public int addCartItem(String book_id, String username, int sum) {
                HashMap<String,Object> bookList=cartItemDao.getBook(book_id,username);
//                int repertory=Integer.valueOf(bookDao.getBookByID(book_id).get("repertory").toString());
                if(bookList!=null)
                {
                        //商品已存在 改变数量即可（PS：还要改变创建时间
                        int sum_new=sum+Integer.valueOf(bookList.get("sum").toString());
//                        if(sum_new>repertory)
//                        {
//                                return -1;
//                        }
                        Date now = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
                        String create_time = dateFormat.format(now);
                        cartItemDao.updateCartItem(book_id,username,sum_new,create_time,bookList.get("update_time").toString());
                }else{
//                        if(sum>repertory)
//                        {
//                                return -1;
//                        }
                        User user=userDao.getUserByName(username);
                        //商品不存在
                        cartItemDao.addCartItem(book_id,user.getId(),sum);
                }
                return 1;
        }

        @Override
        public int updateCartItem(String book_id,String username,int sum) {
                HashMap<String,Object> bookList=cartItemDao.getBook(book_id,username);
//                int repertory=Integer.valueOf(bookDao.getBookByID(book_id).get("repertory").toString());
//                if(sum>repertory)
//                        return -1;
                cartItemDao.updateCartItem(book_id,username,sum,bookList.get("create_time").toString(),bookList.get("update_time").toString());
                return 1;
        }

        @Override
        public void deleteCartItem(String Book_IDs, String username) {
                String[] ids=Book_IDs.split(",");
                for(String book_id:ids) {
                        cartItemDao.deleteCartItem(book_id, username);
                }
        }
}
