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
        return categoryDao.addMainCategory(main_category);
    }

    @Override
    public int addSecondCategory(String main_category, String second_category) {
        return categoryDao.addSecondCategory(main_category,second_category);
    }

    @Override
    public int deleteMainCategory(String main_category) {
        return categoryDao.deleteMainCategory(main_category);
    }

    @Override
    public int deleteSecondCategory(String main_category, String second_category) {
        return categoryDao.deleteSecondCategory(main_category, second_category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }
}
