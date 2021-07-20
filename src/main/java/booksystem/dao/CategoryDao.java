package booksystem.dao;

import booksystem.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface CategoryDao {
    //获取所有目录
    List<Category> getAllCategory();
//    //添加目录
//    int addCategory(String pid,String category_name);
//
//    //删除目录
//    int deleteCategory(String id,String category_name);
//    //更新目录名
//    int updateCategory(Category category);
//    //通过二级目录和一级目录查找
//    List<Category> getCategory(String id,String category_name);
}
