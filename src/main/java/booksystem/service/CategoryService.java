package booksystem.service;

import booksystem.pojo.Category;

import java.util.List;

public interface CategoryService {
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
