package top.yjx1125.anime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import top.yjx1125.anime.mapper.commentMapper;
import top.yjx1125.anime.pojo.comments;
import top.yjx1125.anime.service.CommentService;
import top.yjx1125.anime.utils.ThreadLocalUtil;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private  commentMapper commentMapper;
    @Override
    public void add(comments comment) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer)map.get("id");
        comment.setUserId(id);
        commentMapper.add(comment);
    }

    @Override
    public List<comments> allComments(Integer postId) {
        return commentMapper.allComments(postId);

    }

    @Override
    public List<comments> myComments() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id =  (Integer) map.get("id");
        return commentMapper.myComments(id);
    }

    @Override
    public void delete(Integer id) {
        commentMapper.delete(id);
    }
}
