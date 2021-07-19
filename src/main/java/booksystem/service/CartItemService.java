package booksystem.service;

import booksystem.pojo.CartItem;

public interface CartItemService {
    //根据user_id来获取购物车信息
    CartItem getCartItem(String user_id);
}
