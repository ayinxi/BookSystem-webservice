package booksystem.utils;

import booksystem.pojo.FtpServer;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;

import java.io.*;
import java.util.Locale;
import java.util.UUID;

public class ImgUtils {

    public static File compressPicture(
            File imgFile, long desFileSize, Double quality,String prefix)
    {
        byte[] imageBytes=fileToByte(imgFile);
        if (imageBytes == null || imageBytes.length <= 0) {
            return byteToFile(imageBytes,prefix);
        }
        long srcSize = imageBytes.length;
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
            ByteArrayOutputStream outputStream= new ByteArrayOutputStream(imageBytes.length);
            Thumbnails.of(inputStream).scale(1f).outputQuality(quality).toOutputStream(outputStream);
            imageBytes = outputStream.toByteArray();
            //" 图片原大小={}kb | 压缩后大小={}kb",
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteToFile(imageBytes,prefix);
    }

    public static byte[] fileToByte(File file) {
        byte[] data = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            data = baos.toByteArray();

            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static File byteToFile(byte[] buf, String prefix){
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file=null;
        try{

            file = File.createTempFile(String.valueOf(UUID.randomUUID()).
                    replace("-","").toUpperCase(Locale.ROOT), prefix);

            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if (bos != null){
                try{
                    bos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    public static void main(String[] args) {
        //测试用
        try {
            // 创建一个FtpClient对象
            FTPClient ftpClient = new FTPClient();
            // 创建ftp连接，默认21端口
            ftpClient.connect(FtpServer.hostname, 21);
            // 登录ftp服务器，使用用户名和密码
            ftpClient.login(FtpServer.User, FtpServer.Password);
            // 上传文件
            // 读取本地文件


            File file=new File("C:\\Users\\86150\\Pictures\\background\\6323AD2DD6FB0F40309384EDDCA414D8.jpg");
            File compressedFile=compressPicture(file,1,0.15,".jpg");

            FileInputStream inputStream = new FileInputStream(compressedFile);

            // 被动模式：服务端开放端口给客户端用
            ftpClient.enterLocalPassiveMode();
            // 设置上传的路径
            ftpClient.changeWorkingDirectory(FtpServer.imgUrl);
            // 修改上传文件的格式，采用二进制的方式
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //（服务器文档名，上传文档的inputStream）
            ftpClient.storeFile("sb.jpg", inputStream);
            // 关闭连接
            ftpClient.logout();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
