package booksystem.service.Impl;

import booksystem.dao.CategoryDao;
import booksystem.pojo.Category;
import booksystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    public int addMainCategory(String main_category) {
        if(main_category.isEmpty())
            return 0;//目录名未空
        if(!categoryDao.getCategory(main_category,null).isEmpty())
            return -1;//该目录已存在
        categoryDao.addCategory(main_category,null);
        return 1;
    }

    @Override
    public int addSecondCategory(String main_category, String second_category) {
        if(main_category.isEmpty()||second_category.isEmpty())
            return 0;//目录名未空
        if(!categoryDao.getCategory(main_category,second_category).isEmpty())
            return -1;//该目录已存在
        categoryDao.addCategory(main_category,second_category);
        return 1;
    }

    @Override
    public int deleteMainCategory(String main_category) {
        return categoryDao.deleteCategory(main_category,null);
    }

    @Override
    public int deleteSecondCategory(String main_category, String second_category) {
        return categoryDao.deleteCategory(main_category, second_category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }
}
