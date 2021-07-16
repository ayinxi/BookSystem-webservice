package booksystem.controller;

import booksystem.pojo.Shop;
import booksystem.pojo.User;
import booksystem.service.ShopService;
import booksystem.service.UploadImgService;
import booksystem.service.UserService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import booksystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;
    @Autowired
    UserService userService;
    @Autowired
    UploadImgService uploadImgService;

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

    //根据username获取商家现存的店铺信息
    @RequestMapping("/admin/getShopByUsername")
    public Result getShopByUsername(@RequestParam("username")String username)
    {
        List<Shop> result=shopService.getShopByUsername(username);
        if(result!=null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
    }

    //店铺注册
    @RequestMapping("/registerShop")
    public Result register(@RequestParam("shopper_name") String shopper_name,@RequestParam("shop_name") String shop_name,@RequestParam("apply_reason") String apply_reason,@RequestParam("img") MultipartFile img, ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        User user=userService.getUserByName(username);
        int result=shopService.registerShop(user.getId(),shopper_name,shop_name,apply_reason);
        if(result==1)
        {
            if (!img.isEmpty()) {
            uploadImgService.uploadImg(img, username);
        }
            return Result.ok(ResultEnum.SUCCESS.getMsg());

        }else if(result==0)
        {
            return Result.error(ResultEnum.REGISTER_FAIL.getCode(),ResultEnum.REGISTER_FAIL.getMsg());
        }else if(result==2)
        {
            return Result.error(ResultEnum.SHOP_IS_APPLY.getCode(),ResultEnum.SHOP_IS_APPLY.getMsg());
        }else
        {
            return Result.error(ResultEnum.SHOP_IS_EXISTS.getCode(),ResultEnum.SHOP_IS_EXISTS.getMsg());
        }
    }

    //店铺注销 根据user_id删除店铺
    public Result deleteShop(String username){
        return null;
    }
}
