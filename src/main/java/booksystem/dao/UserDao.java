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
    User getUserByID(String user_id);
    //添加一个用户
    void addUser(String email,String password,String name,int status,String activationCode);
    //删除一个用户
    void deleteUser(String user_id);
    //更新用户
    int updateUser(User user);
    //更新用户激活状态和激活码
    int updateStatus(String username,int status);
    int updateCode(String username,String activationCode);
    int updateTime(String username);
}
