package top.yjx1125.anime.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.yjx1125.anime.pojo.comments;

import java.util.List;

@Mapper
public interface commentMapper {
    @Insert("insert into comments(body,user_id,post_id) values(#{body},#{userId},#{postId})")
    void add(comments comment);

    @Select("select * from comments where post_id = #{postId}")
    List<comments> allComments(Integer postId);

    @Select("select * from comments where user_id = #{id} order by id DESC")
    List<comments> myComments(Integer id);

    @Delete("delete from comments where id = #{id}")
    void delete(Integer id);
}
