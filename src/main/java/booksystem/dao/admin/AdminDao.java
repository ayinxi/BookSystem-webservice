package booksystem.dao.admin;

import booksystem.pojo.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminDao {
    List<Admin> getAllAdmin();
    int addAdmin(Admin admin);
    int deleteAdmin(String ID);
    int updateAdmin(Admin admin);
}
