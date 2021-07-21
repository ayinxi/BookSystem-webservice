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
import java.util.*;

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

        //获取用户的购物车
        @Override
        public List<Map<String,Object>> getCartItem(String username) {
                class Group{
                        public String shop_id;
                        public String shop_name;
                        public Group(String id,String name){
                                shop_id=id;
                                shop_name=name;
                        }

                }
                List<Map<String,Object>> mapList=cartItemDao.getCartItem(username);
                List<Map<String,Object>> res=new ArrayList<>();
                List<Group> allShopId=new ArrayList<>();
                if(mapList.isEmpty())
                        return null;
                for(Map<String,Object> map:mapList) {
                        allShopId.add(new Group(map.get("shop_id").toString(),map.get("shop_name").toString()));
                }

                //去重
                TreeSet shopIdSet = new TreeSet(allShopId);
                allShopId.clear();
                allShopId.addAll(shopIdSet);

                for(int i=0;i<allShopId.size();i++){
                }



                return mapList;
        }

        //添加商品
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

        //更新商品(仅数量
        @Override
        public int updateCartItem(String book_id,String username,int sum) {
                HashMap<String,Object> bookList=cartItemDao.getBook(book_id,username);
//                int repertory=Integer.valueOf(bookDao.getBookByID(book_id).get("repertory").toString());
//                if(sum>repertory)
//                        return -1;
                cartItemDao.updateCartItem(book_id,username,sum,bookList.get("create_time").toString(),bookList.get("update_time").toString());
                return 1;
        }

        //删除商品
        @Override
        public void deleteCartItem(String Book_IDs, String username) {
                String[] ids=Book_IDs.split(",");
                for(String book_id:ids) {
                        cartItemDao.deleteCartItem(book_id, username);
                }
        }

        //获取购物车条目数
        @Override
        public int getCartItemNum(String username) {
                return cartItemDao.getCartItemNum(username);
        }
}
