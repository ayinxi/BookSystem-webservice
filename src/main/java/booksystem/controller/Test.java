package booksystem.controller;

import booksystem.service.UploadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class Test {
    @Autowired
    UploadImgService uploadImgService;
    @GetMapping("/test/{lala}")
    public String test(@PathVariable String lala){
        return lala+"5201314";
    }

    @RequestMapping(value="/test/upload",method=RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("img") MultipartFile img) {
        String contentType = img.getContentType();    // 获取文件的类型
        System.out.println("文件类型为：" +  contentType);
        // 判断文件是否为空
        if(!img.isEmpty()) {
            uploadImgService.uploadImg(img);
        }
            return "SUCCESS";
        }
}
