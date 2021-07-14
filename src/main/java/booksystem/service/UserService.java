package booksystem.service;

import booksystem.pojo.User;

import java.util.List;

public interface UserService {
    //获取所有用户
    List<User> getAllUser();
    //根据用户username获取用户信息
    User getUserByName(String username);
    User getUserByID(String user_id);
    //添加一个用户
    void addUser(String email,String password,String name);
    //删除一个用户
    void deleteUser(String user_id);
    //更新用户
    int updateUser(User user);
}
