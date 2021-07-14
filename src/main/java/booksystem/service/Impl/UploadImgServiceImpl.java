package booksystem.service.Impl;

import booksystem.dao.UploadImgDao;
import booksystem.pojo.FtpServer;
import booksystem.service.UploadImgService;

import java.util.Locale;
import java.util.UUID;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class UploadImgServiceImpl implements UploadImgService {

    @Autowired
    UploadImgDao uploadImgDao;
    @Override
    public void updateImgUrl(String username,String url_b,String url_s) {
        uploadImgDao.updateImgUrl(username,url_b,url_s);
    }

    @Override
    public String uploadImg(MultipartFile multipartFile) {

        try {
            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();
            // 获取文件后缀
            String prefix=fileName.substring(fileName.lastIndexOf("."));
            // 用uuid作为文件名，防止生成的临时文件重复
            final File imgFile = File.createTempFile(String.valueOf(UUID.randomUUID()).
                    replace("-","").toUpperCase(Locale.ROOT), prefix);
            // MultipartFile to File
            multipartFile.transferTo(imgFile);
            // 创建一个FtpClient对象
            FTPClient ftpClient = new FTPClient();
            // 创建ftp连接，默认21端口
            ftpClient.connect(FtpServer.hostname, 21);
            // 登录ftp服务器，使用用户名和密码
            ftpClient.login(FtpServer.User, FtpServer.Password);
            // 上传文件
            // 读取本地文件
            FileInputStream inputStream = new FileInputStream(imgFile);
            // 被动模式：服务端开放端口给客户端用
            ftpClient.enterLocalPassiveMode();
            // 设置上传的路径
            ftpClient.changeWorkingDirectory(FtpServer.imgUrl);
            // 修改上传文件的格式，采用二进制的方式
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //（服务器文档名，上传文档的inputStream）
            ftpClient.storeFile(imgFile.getName(), inputStream);
            // 关闭连接
            ftpClient.logout();
        }catch (IOException e){
            e.printStackTrace();
        }
        return FtpServer.accessUrl+"9EB.jpg";
    }

//    @Test
//    public void uploadImg() {
//
//        try {
//            // 创建一个FtpClient对象
//            FTPClient ftpClient = new FTPClient();
//            // 创建ftp连接，默认21端口
//            ftpClient.connect(FtpServer.hostname, 21);
//            // 登录ftp服务器，使用用户名和密码
//            ftpClient.login(FtpServer.User, FtpServer.Password);
//            // 上传文件
//            // 读取本地文件
//            FileInputStream inputStream = new FileInputStream(
//                    new File("C:\\Users\\86150\\Pictures\\background\\6323AD2DD6FB0F40309384EDDCA414D8.jpg"));
//            // 被动模式：服务端开放端口给客户端用
//            ftpClient.enterLocalPassiveMode();
//            // 设置上传的路径
//            ftpClient.changeWorkingDirectory(FtpServer.imgUrl);
//            // 修改上传文件的格式，采用二进制的方式
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//            //（服务器文档名，上传文档的inputStream）
//            ftpClient.storeFile("9EB.jpg", inputStream);
//            // 关闭连接
//            ftpClient.logout();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public String getImgUrl(String username) {
        return uploadImgDao.getImgUrl(username);
    }
}
