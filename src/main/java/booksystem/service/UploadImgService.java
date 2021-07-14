package booksystem.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImgService {
    void updateImgUrl(String username,String url);
    String uploadImg(MultipartFile img);
    String getImgUrl(String username);
}
