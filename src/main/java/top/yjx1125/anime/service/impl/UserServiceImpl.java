package top.yjx1125.anime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yjx1125.anime.mapper.userMapper;
import top.yjx1125.anime.pojo.Result;
import top.yjx1125.anime.pojo.User;
import top.yjx1125.anime.service.UserService;
import top.yjx1125.anime.utils.Md5Util;
import top.yjx1125.anime.utils.ThreadLocalUtil;

import java.util.Map;
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

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(newPwd),id);
    }
}
