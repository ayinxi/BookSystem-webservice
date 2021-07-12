package booksystem.controller;

import booksystem.service.UserLoginService;
import booksystem.utils.Result;
import booksystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLogin {

    @Autowired
    UserLoginService userLoginService;

    @PostMapping ("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        int res=userLoginService.userLogin(username,password);
        if(res==0){
            Result result=Result.ok("登录失败");
            result.put("code",201);
            return result;
        }
        String token=TokenUtils.generateToken(username,password);
        Result result=Result.ok("登录成功").put("token",token);
        return result;
    }
}
