package booksystem.controller;

import booksystem.pojo.Shop;
import booksystem.service.ShopService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    //获取审核过的店铺
    @RequestMapping("/admin/getCheckShop")
    public Result getCheckShop(){
        List<Shop>result=shopService.getShop(2,3,4);
        if(result!=null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //获取未审核的店铺
    @RequestMapping("/admin/getNonCheckShop")
    public Result getNonCheckShop(){
        List<Shop>result=shopService.getShop(1,1,1);
        if(result!=null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //获取现有店铺
    @RequestMapping("/admin/getPassShop")
    public Result getPassShop(){
        List<Shop>result=shopService.getShop(2,2,2);
        if(result!=null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //获取现有店铺总数
    @RequestMapping("/admin/getPassShopNum")
    public Result getPassShopNum(){
        int result=shopService.getShopNum(3);//未注销
        if(result>=0)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }


    //获取审核过的总数
    @RequestMapping("/admin/getCheckShopNum")
    public Result getCheckShopNum(){
        int result1=shopService.getShopNum(2);//拒绝
        int result2=shopService.getShopNum(3);//未注销
        int result3=shopService.getShopNum(4);//已注销
        int result=result1+result2+result3;
        if(result>=0)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //获取未审核店铺总数
    @RequestMapping("/admin/getNonCheckShopNum")
    public Result getNonCheckShopNum(){
        int result=shopService.getShopNum(1);
        if(result>=0)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //根据user_id获取店铺信息
    public Result getShopByUserName(String username)
    {
        return null;
    }
    //店铺注册
    public Result registerShop(){
        return null;
    }
    //店铺注销 根据user_id删除店铺
    public Result deleteShop(String username){
        return null;
    }
}
