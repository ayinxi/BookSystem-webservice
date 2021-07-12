package booksystem.service.Impl;

import booksystem.dao.UserLoginDao;
import booksystem.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserLoginDao userLoginDao;
    @Override
    public int userLogin(String username, String password) {
        return userLoginDao.userLogin(username,password);
    }
}
