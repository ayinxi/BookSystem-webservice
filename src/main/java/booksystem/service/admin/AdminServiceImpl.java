package booksystem.service.admin;

import booksystem.dao.admin.AdminDao;
import booksystem.pojo.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminDao adminDao;

    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public Admin getAdminByName(String username){
        return adminDao.getAdminByName(username);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public int deleteAdmin(String ID) {
        return adminDao.deleteAdmin(ID);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }
}
