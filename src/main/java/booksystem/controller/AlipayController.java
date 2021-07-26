package booksystem.controller;

import booksystem.dao.OrderDao;
import booksystem.pojo.AliPay;
import booksystem.service.PayService;
import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

public class AlipayController {
    @Resource
    private PayService payService;//调用支付服务
    @Autowired
    OrderDao orderDao;

    /*阿里支付*/
//    https://opendocs.alipay.com/apis/api_1/alipay.trade.precreate/      api文档
    @RequestMapping(value = "/alipay", produces = {"text/html;charset=UTF-8"})
    public String alipay(@RequestParam("order_id") String order_id,//订单id
                         @RequestParam("subject") String subject,//订单名称
                         @RequestParam("total_amount") String total_amount,//付款金额
                         @RequestParam("body") String body//商品描述，（可缺省
                         ) throws AlipayApiException {

        return  payService.aliPay(new AliPay(order_id,subject,total_amount,body));
    }

    @RequestMapping("alipay/return")
    public String toIndex(){
        return "index";
    }
}
