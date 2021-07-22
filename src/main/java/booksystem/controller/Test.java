package booksystem.controller;

import booksystem.dao.BookDao;
import booksystem.service.UploadImgService;
import booksystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
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
}
