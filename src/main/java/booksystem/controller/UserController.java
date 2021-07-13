package booksystem.controller;

import booksystem.pojo.User;
import booksystem.service.UserService;
import booksystem.utils.Result;
import booksystem.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //获取所有用户
    @RequestMapping("/admin/user/getAllUser")
    public Result getAllUser(){
        List<User> result=userService.getAllUser();
        if(result!=null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //用户username查找用户
    @RequestMapping("/admin/user/getUserByName/{username}")
    public Result getUserByName(@PathVariable("username") String username){
        User result=userService.getUserByName(username);
        if(result!=null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else{
            return Result.error(ResultEnum.User_NOT_EXIST.getCode(),ResultEnum.User_NOT_EXIST.getMsg());
        }
    }

    @RequestMapping("/insertUser")
    public Result addUser(@RequestBody User user){
        int result=userService.addUser(user);
        if(result==0)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else{
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //删除一个用户
    @RequestMapping("/admin/user/deleteUser/{user_id}")
    public Result deleteUser(@PathVariable("user_id") String user_id){
        int result=userService.deleteUser(user_id);
        if(result==0)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else{
            return Result.error(ResultEnum.DELETE_FAIL.getCode(),ResultEnum.DELETE_FAIL.getMsg());
        }
    }
    //更新用户
    @RequestMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        int result=userService.updateUser(user);
        if(result==0)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else{
            return Result.error(ResultEnum.UPDATE_FAIL.getCode(),ResultEnum.UPDATE_FAIL.getMsg());
        }
    }
}
