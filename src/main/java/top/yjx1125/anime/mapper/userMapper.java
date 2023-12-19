package top.yjx1125.anime.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Update("update user set nickname = #{nickname},email = #{email} where id = #{id}")
    void update(User user);

    @Update("update user set user_pic = #{avatarUrl} where id = #{id}")
    void updateAvatar(String avatarUrl,Integer id);

    @Update("update user set password = #{md5String} where id = #{id}")
    void updatePwd(String md5String, Integer id);
}
