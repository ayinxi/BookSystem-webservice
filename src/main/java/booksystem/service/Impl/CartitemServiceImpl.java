package booksystem.service.Impl;

import booksystem.dao.CartitemDao;
import booksystem.pojo.Cartitem;
import booksystem.service.CartitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartitemServiceImpl implements CartitemService {
        @Autowired
        CartitemDao cartitemDao;

        @Override
        public Cartitem getCaetitem(String user_id) {
                return cartitemDao.getCaetitem(user_id);
        }
}
