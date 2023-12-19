package top.yjx1125.anime.controller;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
import top.yjx1125.anime.pojo.Result;
import top.yjx1125.anime.pojo.User;
import top.yjx1125.anime.service.UserService;
import top.yjx1125.anime.utils.JwtUtil;
import top.yjx1125.anime.utils.Md5Util;
import top.yjx1125.anime.utils.ThreadLocalUtil;

import java.net.PortUnreachableException;
import java.util.HashMap;
import java.util.Map;
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
         if(!isMatch) {
            return Result.error("用户名不合法");
         }
         else {
            return Result.error("密码不合法");
         }
      }
   }

   @PostMapping("/login")
   public Result<String> login(String username,String password){
      User u = userService.findByUserName(username);
      if(u==null){
        return Result.error("用户名错误");
      }
      if(Md5Util.getMD5String(password).equals(u.getPassword())){
         Map<String,Object> claims = new HashMap<>();
         claims.put("id",u.getId());
         claims.put("username",u.getUsername());
         String token = JwtUtil.genToken(claims);

        return Result.success(token);

      }
      return  Result.error("密码错误");

   }

   @GetMapping("/userinfo")
   public Result<User> userInfo(){//@RequestHeader(name="Authorization") String token
//          Map<String,Object> map = JwtUtil.parseToken(token);

           Map<String,Object> map = ThreadLocalUtil.get();
           String username =(String) map.get("username");
          User u = userService.findByUserName(username);
          return Result.success(u);

   }

   @PutMapping("/update")
   public Result update(@RequestBody @Validated User user){
       userService.update(user);
       return Result.success();

   }

   @PatchMapping("/updateAvatar")
   public Result updateAvatar(@RequestParam @URL String avatarUrl){
       userService.updateAvatar(avatarUrl);
       return Result.success();
   }

   @PatchMapping("/updatePwd")
   public Result updatePwd(@RequestBody Map<String,String> params){
      String old_pwd = params.get("old_pwd");
      String new_pwd = params.get("new_pwd");
      String re_pwd = params.get("re_pwd");
      if(!StringUtils.hasLength(old_pwd)||!StringUtils.hasLength(new_pwd)||!StringUtils.hasLength(re_pwd)){
         return Result.error("缺少必要参数");
      }
      Map<String,Object> map = ThreadLocalUtil.get();
      User loginUser = userService.findByUserName((String) map.get("username"));

      if(!loginUser.getPassword().equals(Md5Util.getMD5String(old_pwd))){
             return Result.error("原密码错误");
      }
      if(!re_pwd.equals(new_pwd)){
         return Result.error("两次密码不同");
      }
      String regex = "^[\\w]{4,12}$";
      boolean isMatch = Pattern.matches(regex,re_pwd);
      if(!isMatch){
         Result.error("密码不合法");
      }

      userService.updatePwd(new_pwd);
      return Result.success();
   }


}
