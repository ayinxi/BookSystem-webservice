package booksystem.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImgService {
    void updateImgUrl(String username,String url_b,String url_s);
    String uploadImg(MultipartFile img,String username);
    String getImgUrl(String username);
}
