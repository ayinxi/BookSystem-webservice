package booksystem.service.Impl;

import booksystem.dao.UserDao;
import booksystem.pojo.User;
import booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public void addUser(String email,String password,String name) {
        userDao.addUser(email,password,name);
    }

    @Override
    public int deleteUser(String user_id) {
        return userDao.deleteUser(user_id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
