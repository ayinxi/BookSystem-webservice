package booksystem.controller;

import booksystem.service.CartItemService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import booksystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CartitemController {
    @Autowired
    CartItemService cartItemService;


    @RequestMapping("/cartitem/getAllByUser")
    public Result getAllByUser(ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();

        return Result.ok().put("data",cartItemService.getCartItem(username));
    }

    @RequestMapping("/cartitem/addCartItem")
    public Result addCartItem(@RequestParam("book_id") String book_id,
                              @RequestParam("sum")int sum,
                              ServletRequest request){

        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        int result=cartItemService.addCartItem(book_id,username,sum);
        if(result==1)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else if(result==-1){
            return Result.error(ResultEnum.NUM_IS_NOT_ENOUGH.getCode(),ResultEnum.NUM_IS_NOT_ENOUGH.getMsg());
        }else{
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }


    @RequestMapping("/cartitem/updateCartItem")
    public Result updateCartItem(@RequestParam("book_id") String book_id,
                                 @RequestParam("sum")int sum,
                                 ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        int result=cartItemService.updateCartItem(book_id,username,sum);
        if(result==1)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else {
            return Result.error(ResultEnum.NUM_IS_NOT_ENOUGH.getCode(), ResultEnum.NUM_IS_NOT_ENOUGH.getMsg());
        }
    }

    @DeleteMapping("/cartitem/deleteCartItem")
    public Result deleteCartItem(@RequestParam("Book_Ids") String Book_Ids,ServletRequest request) {
        String token = ((HttpServletRequest) request).getHeader("token");
        String username = TokenUtils.parseToken(token).get("username").toString();
        cartItemService.deleteCartItem(Book_Ids,username);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }
}