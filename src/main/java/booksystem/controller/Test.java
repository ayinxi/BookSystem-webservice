package booksystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class Test {
    @GetMapping("/test/{lala}")
    public String test(@PathVariable String lala){
        return lala+"5201314";
    }

    @RequestMapping(value="/test/upload",method=RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("img") MultipartFile img, HttpServletRequest request, HttpServletResponse response) {
        String contentType = img.getContentType();    // 获取文件的类型
        System.out.println("文件类型为：" +  contentType);
        String originalFilename = img.getOriginalFilename();     // 获取文件的原始名称
        // 判断文件是否为空
        if(!img.isEmpty()) {
            File targetImg = new File("F:/img");
            // 判断文件夹是否存在
            if(!targetImg.exists()) {
                targetImg.mkdirs();    //级联创建文件夹
            }
                try {
                // 开始保存图片
                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\86150\\Desktop" + originalFilename);
                outputStream.write(img.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return "SUCCESS";
        }
}
