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
    public int updateAddress(Address[] address) {
        return addressDao.updateAddress(address);
    }
}
