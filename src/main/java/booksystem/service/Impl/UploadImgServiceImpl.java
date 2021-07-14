package booksystem.service.Impl;

import booksystem.dao.UploadImgDao;
import booksystem.service.UploadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class UploadImgServiceImpl implements UploadImgService {
    @Autowired
    UploadImgDao uploadImgDao;
    @Override
    public void updateImgUrl(String username,String url) {
        uploadImgDao.updateImgUrl(username,url);
    }

    @Override
    public String uploadImg(MultipartFile img) {
        return null;
    }

    @Override
    public String getImgUrl(String username) {
        return uploadImgDao.getImgUrl(username);
    }
}
