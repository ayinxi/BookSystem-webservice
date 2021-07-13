package booksystem.controller;

import booksystem.pojo.Address;
import booksystem.service.AddressService;
import booksystem.service.Impl.AddressServiceImpl;
import booksystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins="*",maxAge = 3600)
@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    //根据user_id获取所有地址
    @RequestMapping("/user/getAllAddress")
    public Result getAllAddress(String user_id){
        return Result.ok().put("data",addressService.getAllAddress(user_id));
    }
    //添加一个地址
    @RequestMapping("/user/addAddress")
    public Result addAddress(Address address){
        int result= addressService.addAddress(address);
        if(result>0)
        {
            return Result.ok("操作成功");
        }
        return Result.ok("操作失败");
    }
    //删除一个地址
    @RequestMapping("/user/deleteAddress")
    public Result deleteAddress(String address_id){
        int result= addressService.deleteAddress(address_id);
        if(result>0)
        {
            return Result.ok("操作成功");
        }
        return Result.ok("操作失败");
    }
    //修改地址信息
    @RequestMapping("/user/updateAddress")
    public Result updateAddress(Address address){
        int result= addressService.updateAddress(address);
        if(result>0)
        {
            return Result.ok("操作成功");
        }
        return Result.ok("操作失败");
    }
}
