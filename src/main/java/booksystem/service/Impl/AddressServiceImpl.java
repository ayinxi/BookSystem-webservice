package booksystem.service.Impl;

import booksystem.dao.AddressDao;
import booksystem.pojo.Address;
import booksystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;
    @Override
    public List<Address> getAllAddress(String user_id) {
        return addressDao.getAllAddress(user_id);
    }


    @Override
    public void updateAddress(String id,String address,String name,String phone) {
        addressDao.updateAddress(id,address,name,phone);
    }

    @Override
    public void insertAddress(String address, String name, String phone, String username) {
        addressDao.insertAddress(address,name,phone,username);
    }

    @Override
    public void deleteAddress(String id) {
        addressDao.deleteAddress(id);
    }

    @Override
    public void setDefault(String id) {
        addressDao.setDefault(id);
    }
}
