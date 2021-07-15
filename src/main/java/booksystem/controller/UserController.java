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
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    //用户username查找用户
    @RequestMapping("/user/getByUsername")
    public Result getUserByName(@RequestParam("username") String username){
        User result=userService.getUserByName(username);
        if(result!=null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.User_NOT_EXIST.getCode(),ResultEnum.User_NOT_EXIST.getMsg());
        }
    }

    //用户user_id查找用户
    @RequestMapping("/user/getByID")
    public Result getUserByID(@RequestParam("user_id") String user_id){
        User result=userService.getUserByID(user_id);
        if(result!=null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg()).put("data",result);
        }else{
            return Result.error(ResultEnum.User_NOT_EXIST.getCode(),ResultEnum.User_NOT_EXIST.getMsg());
        }
    }

    @PostMapping("/sendEmail")
    @ResponseBody
    public Result sendEmail(@RequestParam("password") String password,
                            @RequestParam("email") String email,
                            @RequestParam("name") String name) {
        int result = userService.sendMimeMail(password, email, name);
        if (result == 1) {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        } else if(result==-1){
            return Result.error(ResultEnum.User_IS_EXISTS.getCode(), ResultEnum.User_IS_EXISTS.getMsg());
        }else {
            return Result.error(ResultEnum.REGISTER_FAIL.getCode(), ResultEnum.REGISTER_FAIL.getMsg());
        }
    }

    @PostMapping("/register")
    public Result register(@RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("name") String name,
                           @RequestParam("activationCode") String activationCode) {
        int result=userService.register(password, email, name, activationCode);
        if (result ==2) {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        } else if(result==1){
            return Result.error(ResultEnum.CODE_FAIL.getCode(), ResultEnum.CODE_FAIL.getMsg());
        }else if(result==0)
        {
            return Result.error(ResultEnum.EMAIL_FAIL.getCode(), ResultEnum.EMAIL_FAIL.getMsg());
        }else if(result==-1)
        {
            return Result.error(ResultEnum.Code_OUTTIME.getCode(), ResultEnum.Code_OUTTIME.getMsg());
        }else
        {
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    //删除一个用户
    @DeleteMapping("/admin/user/delete")
    public Result deleteUser(@RequestParam("user_id") String user_id){
        userService.deleteUser(user_id);
        User result=userService.getUserByID(user_id);
        if(result==null)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else{
            return Result.error(ResultEnum.DELETE_FAIL.getCode(),ResultEnum.DELETE_FAIL.getMsg());
        }
    }
    //更新用户
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        int result=userService.updateUser(user);
        if(result!=0)
        {
            return Result.ok(ResultEnum.SUCCESS.getMsg());
        }else{
            return Result.error(ResultEnum.UPDATE_FAIL.getCode(),ResultEnum.UPDATE_FAIL.getMsg());
        }
    }
}
