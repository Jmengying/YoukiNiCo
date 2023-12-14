package top.yjx1125.anime.service;

import top.yjx1125.anime.pojo.User;

public interface UserService {
    //根据username查询用户
    User findByUserName(String username);
    //注册用户
    void register(String username, String password);
}
