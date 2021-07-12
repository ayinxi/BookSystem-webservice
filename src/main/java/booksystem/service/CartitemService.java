package booksystem.service;

import booksystem.pojo.Cartitem;

public interface CartitemService {
    //根据user_id来获取购物车信息
    Cartitem getCaetitem(String user_id);
}
