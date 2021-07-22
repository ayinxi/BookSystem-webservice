package booksystem.controller;

import booksystem.service.OrderService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import booksystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    //购物车购买
    @RequestMapping("/order/addDirect")
    public Result addDirect(@RequestParam("book_id") String book_id,
                            @RequestParam("sum") int sum,
                            @RequestParam("address_id") String address_id,
                            @RequestParam("shop_id") String shop_id,
                            ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        int result=orderService.addDirectOrder(book_id,sum,address_id,shop_id,username);
        if(result==1)
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        else
            return Result.error(ResultEnum.NUM_IS_NOT_ENOUGH.getCode(),ResultEnum.NUM_IS_NOT_ENOUGH.getMsg());
    }

    //直接购买
    @RequestMapping("/order/addCatiItem")
    public Result addCatiItem(@RequestParam("Book_Ids") String Book_Ids,
                            @RequestParam("Sums") String Sums,
                            @RequestParam("address_id") String address_id,
                            ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        int result=orderService.addCartItemOrder(Book_Ids,Sums,address_id,username);
        if(result==1)
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        else
            return Result.error(ResultEnum.NUM_IS_NOT_ENOUGH.getCode(),ResultEnum.NUM_IS_NOT_ENOUGH.getMsg());
    }

    //获取所有订单
    @RequestMapping("/admin/getAllOrder")
    public Result getAllOrder()
    {
        return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",orderService.getAllOrder());
    }

    //获取某用户的所有订单
    @RequestMapping("/order/getByUser")
    public Result getAllOrderByUser(ServletRequest request){
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();

        return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",orderService.getAllOrderByUser(username));
    }

    //根据shop_id获取所有订单
    @RequestMapping("/shop/order/getByShop")
    public Result getAllOrderByShop(@RequestParam("shop_id") String shop_id){
        return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",orderService.getAllOrderByShop(shop_id));
    }

    //根据order_id获取某个订单
    @RequestMapping("/order/getByID")
    public Result getOrderByID(@RequestParam("order_id") String order_id){
        return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",orderService.getOrderByID(order_id));
    }
}
