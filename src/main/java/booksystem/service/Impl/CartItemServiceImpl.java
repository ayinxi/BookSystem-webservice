package booksystem.service.Impl;

import booksystem.dao.CartItemDao;
import booksystem.pojo.CartItem;
import booksystem.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
        @Autowired
        CartItemDao cartItemDao;

        @Override
        public CartItem getCartItem(String user_id) {
                return cartItemDao.getCartItem(user_id);
        }
}
