package booksystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//上传图片等
@Repository
@Mapper
public interface UploadImgDao {
    void updateImgUrl(String username,String url_b,String url_s);
    String getImgUrl(String username);
}
