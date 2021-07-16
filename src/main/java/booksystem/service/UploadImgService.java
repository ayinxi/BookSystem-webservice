package booksystem.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImgService {
    String uploadUserImg(MultipartFile img,String username);
    String uploadShopImg(MultipartFile img,String username);
    String uploadBookImg(MultipartFile img,String username);
}
