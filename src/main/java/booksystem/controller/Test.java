package booksystem.controller;

import booksystem.dao.BookDao;
import booksystem.interceptor.PropertiesConfig;
import booksystem.pojo.AliPay;
import booksystem.service.PayService;
import booksystem.service.UploadImgService;
import booksystem.utils.TokenUtils;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class Test {
    @Autowired
    UploadImgService uploadImgService;
    @Autowired
    BookDao bookDao;
    @Resource
    private PayService payService;//调用支付服务


    @GetMapping("/test")
    public String test() throws Exception{
//        throw new Exception("test");
        return "5201314";
    }

    @PostMapping("/testBook")
    public String testBook(@RequestParam("book_id") String book_id,
                           @RequestParam("volume") String volume,
                           @RequestParam("repertory") String repertory){
        bookDao.updateRepertory(book_id,Integer.parseInt(repertory));
        bookDao.updateVolume(book_id,Integer.parseInt(volume));
        return "OK";
    }

    @RequestMapping(value="/test/upload",method=RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("img") MultipartFile img, ServletRequest request) {
        String token=((HttpServletRequest)request).getHeader("token");
        String username= TokenUtils.parseToken(token).get("username").toString();
        // 判断文件是否为空
        if(!img.isEmpty()) {
            uploadImgService.uploadUserImg(img,username);
        }
            return "SUCCESS";
    }



    /*阿里支付*/
    @RequestMapping(value = "/test/alipay", produces = {"text/html;charset=UTF-8"})
    public String alipay(@RequestParam("out_trade_no") String out_trade_no,
                         @RequestParam("subject") String subject,
                         @RequestParam("total_amount") String total_amount,
                         @RequestParam("body") String body) throws AlipayApiException {

        return  payService.aliPay(new AliPay(out_trade_no,subject,total_amount,body));
    }


    @RequestMapping(value = "/favicon.ico")
    public String fav(){
        return  "laalalalalal)";
    }



    @RequestMapping("alipay/callback/return_sult")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/getOrderId")
    public String get(){
        return "index";
    }



}
