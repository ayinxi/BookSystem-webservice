package booksystem.service.Impl;

import booksystem.dao.UploadImgDao;
import booksystem.pojo.FtpServer;
import booksystem.service.UploadImgService;


import java.io.*;
import java.nio.file.Files;
import java.util.Locale;
import java.util.UUID;

import booksystem.utils.ImgUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadImgServiceImpl implements UploadImgService {

    @Autowired
    UploadImgDao uploadImgDao;

    //上传原图
    public String uploadOriginalImg(MultipartFile multipartFile,String fileUrl_b){
        fileUrl_b=fileUrl_b.replace("http://47.94.131.208:8888/img","");

        //先删除原来的图片
        if(!(fileUrl_b.isEmpty()||fileUrl_b.equals("/original/avatar.jpg"))) {
            ImgUtils.deleteImg(FtpServer.imgUrl + fileUrl_b);
        }

        File imgFile=ImgUtils.multipartFileToFile(multipartFile);
        String prefix=imgFile.getName().substring(imgFile.getName().lastIndexOf("."));
        fileUrl_b=ImgUtils.uploadImg(imgFile,"/original");        //上传原图

        return fileUrl_b;
    }

    //上传压缩图
    public String uploadCompressImg(MultipartFile multipartFile,String fileUrl_s){
        fileUrl_s=fileUrl_s.replace("http://47.94.131.208:8888/img","");

        //先删除原来的图片
        if(!(fileUrl_s.isEmpty()||fileUrl_s.equals("/compression/avatar.jpg"))) {
            ImgUtils.deleteImg(FtpServer.imgUrl + fileUrl_s);
        }

        File imgFile=ImgUtils.multipartFileToFile(multipartFile);
        String prefix=imgFile.getName().substring(imgFile.getName().lastIndexOf("."));
        File compressedFile= ImgUtils.compressPicture(imgFile,1,0.1,prefix);
        fileUrl_s=ImgUtils.uploadImg(imgFile,"/compression");        //上传压缩图

        return fileUrl_s;
    }

    @Override
    public String uploadUserImg(MultipartFile multipartFile,String username) {
        String fileUrl_b=uploadImgDao.getUserImgUrl(username).get("avatar_b").toString();
        String fileUrl_s=uploadImgDao.getUserImgUrl(username).get("avatar_s").toString();

        fileUrl_b=uploadOriginalImg(multipartFile,fileUrl_b);
        fileUrl_s=uploadOriginalImg(multipartFile,fileUrl_s);

        //上传到数据库
        uploadImgDao.updateUserImgUrl(username,fileUrl_b,fileUrl_s);

        return fileUrl_b;
    }

    @Override
    public String uploadShopImg(MultipartFile img, String username) {
        String fileUrl_b=uploadImgDao.getShopImgUrl(username).get("avatar_b").toString();
        String fileUrl_s=uploadImgDao.getShopImgUrl(username).get("avatar_s").toString();

        fileUrl_b=uploadOriginalImg(img,fileUrl_b);
        fileUrl_s=uploadOriginalImg(img,fileUrl_s);

        //上传到数据库
        uploadImgDao.updateShopImgUrl(username,fileUrl_b,fileUrl_s);

        return fileUrl_b;
    }

    @Override
    public String uploadBookImg(MultipartFile img, String username) {
        String fileUrl_b=uploadImgDao.getBookImgUrl(username).get("avatar_b").toString();
        String fileUrl_s=uploadImgDao.getBookImgUrl(username).get("avatar_s").toString();

        fileUrl_b=uploadOriginalImg(img,fileUrl_b);
        fileUrl_s=uploadOriginalImg(img,fileUrl_s);

        //上传到数据库
        uploadImgDao.updateBookImgUrl(username,fileUrl_b,fileUrl_s);

        return fileUrl_b;
    }

}
