package booksystem.service;

import booksystem.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    //获取所有目录
    List<Map<String,Object>> getAllCategory();
    String getMainCategory(String name);
    String getSecondCategory(String main_name,String name);
    //添加目录
    void addMainCategory(String name);
    void addSecondCategory(String main_name,String name);
    //删除目录
    void deleteMainCategory(String id);
    void deleteSecondCategory(String id);
    //更新目录名
    void updateMainCategory(String id,String name);
    void updateSecondCategory(String id,String name);
    //通过二级目录和一级目录查找
    Map<String,Object> getCategory(String id,String category_id);
}
