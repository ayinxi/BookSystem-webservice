package booksystem.dao;

import booksystem.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AddressDao {

    //根据user_id获取所有地址
    List<Address> getAllAddress(String user_id);
    //添加一个地址
    int addAddress(Address address);
    //删除一个地址
    int deleteAddress(String address_id);
    //修改地址信息
    int updateAddress(Address address);
}
