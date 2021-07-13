package booksystem.dao;

import booksystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    //获取所有用户
    List<User> getAllUser();
    //根据用户username获取用户信息
    User getUserByName(String username);
    //添加一个用户
    void addUser(String email,String password,String name);
    //删除一个用户
    int deleteUser(String user_id);
    //更新用户
    int updateUser(User user);
}
