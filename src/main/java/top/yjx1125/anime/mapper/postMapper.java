package top.yjx1125.anime.mapper;

import org.apache.ibatis.annotations.*;
import top.yjx1125.anime.pojo.posts;

import java.util.List;

@Mapper
public interface postMapper {
    //添加文章
    @Insert("insert into posts(title,body,user_id) values(#{title},#{body},#{userId})")
    void add(posts post);
    //查询当前账户下的文章
    @Select("select * from posts where user_id = #{id} order by id DESC")
    List<posts> myList(Integer id);
    //查询所有文章
    @Select("select * from posts order by id DESC")
    List<posts> allList();
    //查询某一id的文章
    @Select("select * from posts where id = #{id}")
    posts findById(Integer id);
    //修改文章
    @Update("update posts set title = #{title},body = #{body} where id = #{id}")
    void update(posts post);
    //删除文章
    @Delete("delete from posts where id = #{id}")
    void delete(Integer id);
}
