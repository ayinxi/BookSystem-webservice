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
    //添加目录
    int addCategory(String main_category,String second_category);

    //删除目录
    int deleteCategory(String main_category,String second_category);
    //更新目录名
    int updateCategory(Category category);
    //通过二级目录和一级目录查找
    List<Category> getCategory(String main_category,String second_category);
}
