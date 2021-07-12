package booksystem.dao;

import booksystem.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {
    //获取所有目录
    List<Category> getAllCategory();
    //添加一个一级目录
    int addMainCategory(String main_category);
    //添加一个二级目录
    int addSecondCategory(String main_category,String second_category);
    //删除一个一级目录
    int deleteMainCategory(String main_category);
    //删除一个二级目录
    int deleteSecondCategory(String main_category,String second_category);
    //更新目录名
    int updateCategory(Category category);
}
