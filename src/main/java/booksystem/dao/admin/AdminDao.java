package booksystem.dao.admin;

import booksystem.pojo.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminDao {
    //获取所有管理员
    List<Admin> getAllAdmin();
    //根据管理员username获取管理员信息
    Admin getAdminByName(String username);
    //添加一个管理员
    int addAdmin(Admin admin);
    //删除一个管理员
    int deleteAdmin(String ID);
    //更新管理员
    int updateAdmin(Admin admin);
}
