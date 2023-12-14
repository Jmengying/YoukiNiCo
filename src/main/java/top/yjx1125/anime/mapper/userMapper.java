package top.yjx1125.anime.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.yjx1125.anime.pojo.User;

@Mapper
public interface userMapper {

    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User findByUserName(String username);
    //添加
    @Insert("insert into user(username,password,nickname)"+
    " values(#{username},#{password},#{username})")
    void add(String username, String password);
}
