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
    @Override
    public void updateImgUrl(String username,String url_b,String url_s) {
        uploadImgDao.updateImgUrl(username,url_b,url_s);
    }

    @Override
    public String uploadImg(MultipartFile multipartFile,String username) {
        String fileUrl_b="";
        String fileUrl_s="";
        try {
            String fileName = multipartFile.getOriginalFilename();//原文件名
            String prefix=fileName.substring(fileName.lastIndexOf("."));// 获取文件后缀
            final File imgFile = File.createTempFile(String.valueOf(UUID.randomUUID()).
                    replace("-","").toUpperCase(Locale.ROOT), prefix);

            multipartFile.transferTo(imgFile);
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(FtpServer.hostname, 21);// 创建ftp连接，默认21端口
            ftpClient.login(FtpServer.User, FtpServer.Password);

            //开始传图片
            FileInputStream inputStream = new FileInputStream(imgFile);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(FtpServer.imgUrl+"/original");
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.storeFile(imgFile.getName(), inputStream);
            fileUrl_b=FtpServer.accessUrl+"/original"+"/"+imgFile.getName();//原图地址

            //压缩图片
            File compressedFile= ImgUtils.compressPicture(imgFile,1,0.1,prefix);
            FileInputStream inputStream_s = new FileInputStream(compressedFile);

            //开始传图片
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(FtpServer.imgUrl+"/compression");
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.storeFile(compressedFile.getName(), inputStream_s);
            fileUrl_s=FtpServer.accessUrl+"/compression"+"/"+imgFile.getName();//压缩图地址

            //上传到数据库
            updateImgUrl(username,fileUrl_b,fileUrl_s);

            ftpClient.logout();
        }catch (IOException e){
            e.printStackTrace();
        }
        return fileUrl_b;
    }



    @Override
    public String getImgUrl(String username) {
        return uploadImgDao.getImgUrl(username);
    }
}
