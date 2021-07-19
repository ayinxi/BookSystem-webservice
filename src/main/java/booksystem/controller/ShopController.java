package booksystem.controller;

import booksystem.pojo.Shop;
import booksystem.service.ShopService;
import booksystem.service.UploadImgService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import booksystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;
    @Autowired
    UploadImgService uploadImgService;

    //获取审核过的店铺
    @RequestMapping("/admin/getCheckShop")
    public Result getCheckShop(){
        List<Shop>result=shopService.getCheckShop();
        if(!result.isEmpty())
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //获取未审核的店铺
    @RequestMapping("/admin/getNonCheckShop")
    public Result getNonCheckShop(){
        List<Shop>result=shopService.getNonCheckShop();
        if(!result.isEmpty())
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //获取现有店铺
    @RequestMapping("/admin/getPassShop")
    public Result getPassShop(){
        List<Shop>result=shopService.getPassShop();
        if(!result.isEmpty())
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //获取现有店铺总数
    @RequestMapping("/admin/getPassShopNum")
    public Result getPassShopNum(){
        int result=shopService.getPassShopNum();//未注销
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
        int result=shopService.getCheckShopNum();
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
        int result=shopService.getNonCheckShopNum();
        if(result>=0)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //根据username获取所有状态的店铺信息
    @RequestMapping("/getAllShopByUsername")
    public Result getShopByUsername(@RequestParam("username")String username)
    {
        List<Shop> result=shopService.getShopByUser(username);
        if(!result.isEmpty())
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
    }

    //根据username获取现有的店铺信息
    @RequestMapping("/getPassShopByUsername")
    public Result getPassShopByUsername(@RequestParam("username")String username)
    {
        List<Shop> result=shopService.getShopByUserAndStatus(username,2,1,1);
        if(!result.isEmpty())
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
    }

    //店铺注册
    @PostMapping("/registerShop")
    public Result register(@RequestParam("shopper_name") String shopper_name,
                           @RequestParam("shop_name") String shop_name,
                           @RequestParam("apply_reason") String apply_reason,
                           @RequestParam("img") MultipartFile img,
                           ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        int result=shopService.registerShop(username,shopper_name,shop_name,apply_reason);

        List<Shop> shopList=shopService.getShopByUserAndStatus(username,1,-1,-1);

        Shop shop=shopList.get(0);

        if(result==1)
        {
            if (!img.isEmpty()) {
                uploadImgService.uploadShopImg(img, shop.getId());
            }
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else if(result==-1)
        {
            return Result.error(ResultEnum.SHOP_IS_EXISTS.getCode(),ResultEnum.SHOP_IS_EXISTS.getMsg());

        }else if(result==2)
        {
            return Result.error(ResultEnum.SHOP_IS_APPLY.getCode(),ResultEnum.SHOP_IS_APPLY.getMsg());
        }else
        {
            return Result.error(ResultEnum.REGISTER_FAIL.getCode(),ResultEnum.REGISTER_FAIL.getMsg());
        }
    }

    //审核是否通过
    @PostMapping("/admin/checkShop")
    public Result checkShop(@RequestParam("username") String username,
                            @RequestParam("pass_status") int pass_status,
                            @RequestParam("check_opinion") String check_opinion){
        int result=shopService.checkShop(username,pass_status,check_opinion);
        if(result==1)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());

        }else if(result==-1)
        {
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());

        }else
        {
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //申请信息修改
    @PostMapping("/user/updateShopApply")
    public Result updateShopApply(@RequestParam("shopper_name") String shopper_name,
                           @RequestParam("shop_name") String shop_name,
                           @RequestParam("apply_reason") String apply_reason,
                           @RequestParam("img") MultipartFile img,
                           ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        int result=shopService.updateShopApply(username,shopper_name,shop_name,apply_reason);

        List<Shop> shopList=shopService.getShopByUserAndStatus(username,1,-1,-1);
        if(shopList.isEmpty())
        {
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
        Shop shop=shopList.get(0);

        if(result==1)
        {
            if (!img.isEmpty()) {
                uploadImgService.uploadShopImg(img, shop.getId());
            }
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else if(result==-1)
        {
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());

        }else
        {
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //取消申请
    @PostMapping("/user/cancelShopApply")
    public Result cancelShopApply(ServletRequest request){

        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        int result=shopService.cancelShopApply(username);
        if(result==1)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());

        }else if(result==-1)
        {
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());

        }else
        {
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //店铺修改
    @PostMapping("/user/updateShop")
    public Result updateShop(@RequestParam("shopper_name") String shopper_name,
                                  @RequestParam("shop_name") String shop_name,
                                  @RequestParam("img") MultipartFile img,
                                  ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        int result=shopService.updateShop(username,shopper_name,shop_name);

        List<Shop> shopList=shopService.getShopByUserAndStatus(username,2,1,1);
        Shop shop=shopList.get(0);

        if(result==1)
        {
            if (!img.isEmpty()) {
                uploadImgService.uploadShopImg(img, shop.getId());
            }
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else if(result==-1)
        {
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());

        }else
        {
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //店铺注销 根据username注销店铺
    @DeleteMapping("/logoutShop")
    public Result deleteShop(@RequestParam("username") String username){
        int result=shopService.deleteShop(username);
        if (result == 1) {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        } else if(result==-1){
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(), ResultEnum.DATA_IS_NULL.getMsg());
        }
        else if(result==0){
            return Result.error(ResultEnum.DELETE_FAIL.getCode(), ResultEnum.DELETE_FAIL.getMsg());
        }else {
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }
}
