package top.yjx1125.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yjx1125.anime.pojo.Result;
import top.yjx1125.anime.pojo.User;
import top.yjx1125.anime.service.UserService;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
   private UserService userService;

   @PostMapping("/register")
   public Result register(String username,String password) {
      //判断是否符合标准
      String regex = "^[\\w(\\u4e00-\\u9fa5)]{4,12}$";
      String regex1 = "^[\\w]{4,12}$";
      boolean isMatch = Pattern.matches(regex, username);
      boolean isMatch1 = Pattern.matches(regex1,password);
      if (isMatch&&isMatch1) {
         User u = userService.findByUserName(username);
         //判断是否已被注册
         if (u == null) {//注册
            userService.register(username, password);
            return Result.success();
         } else {
            return Result.error("用户名已被注册");
         }
      }
      else {
         return Result.error("用户名密码不合法");
      }
   }


}
