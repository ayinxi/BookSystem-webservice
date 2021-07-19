package booksystem.controller;

import booksystem.pojo.Category;
import booksystem.service.CategoryService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //获取所有目录
    @RequestMapping("/category/getAll")
    public Result getAllCategory(){
        List<Category> result=categoryService.getAllCategory();
        if(!result.isEmpty())
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //添加一级目录
    @PostMapping("/category/addMain")
    public Result addMainCategory(@RequestParam("main_category") String main_category){
        categoryService.addMainCategory(main_category);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }

    //添加二级目录
    @PostMapping("/category/addSecond")
    public Result addSecondCategory(@RequestParam("main_category") String main_category,
                                    @RequestParam("second_category") String second_category){
        categoryService.addSecondCategory(main_category,second_category);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }

    //删除一级目录
    @PostMapping("/category/deleteMain")
    public Result deleteMainCategory(@RequestParam("main_category") String main_category){
        categoryService.deleteMainCategory(main_category);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }

    //删除二级目录
    @PostMapping("/category/deleteSecond")
    public Result deleteSecondCategory(@RequestParam("main_category") String main_category,
                                    @RequestParam("second_category") String second_category){
        categoryService.deleteSecondCategory(main_category,second_category);
        return Result.ok(ResultEnum.SUCCESS.getMsg());
    }
}
