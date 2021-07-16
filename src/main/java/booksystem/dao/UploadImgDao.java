package booksystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

//上传图片等
@Repository
@Mapper
public interface UploadImgDao {
    void updateUserImgUrl(String username,String url_b,String url_s);
    void updateShopImgUrl(String username,String url_b,String url_s);
    void updateBookImgUrl(String username,String url_b,String url_s);
    HashMap<String,Object> getUserImgUrl(String username);
    HashMap<String,Object> getShopImgUrl(String username);
    HashMap<String,Object> getBookImgUrl(String book_id);
}
