package top.yjx1125.anime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yjx1125.anime.mapper.userMapper;
import top.yjx1125.anime.pojo.Result;
import top.yjx1125.anime.pojo.User;
import top.yjx1125.anime.service.UserService;
import top.yjx1125.anime.utils.Md5Util;

import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private userMapper userMapper;
    @Override
    public User findByUserName(String username){
       User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {


        //加密
       String md5String = Md5Util.getMD5String(password);
        //添加

        userMapper.add(username,md5String);
    }
}
