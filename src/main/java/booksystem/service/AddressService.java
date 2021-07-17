package booksystem.service;

import booksystem.pojo.Address;

import java.util.List;

public interface AddressService {
    //根据user_id获取所有地址
    List<Address> getAllAddress(String user_id);

    //修改地址信息
    int updateAddress(Address[] address);
}
