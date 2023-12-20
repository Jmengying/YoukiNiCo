package top.yjx1125.anime.service;

import top.yjx1125.anime.pojo.comments;

import java.util.List;

public interface CommentService {
    void add(comments comment);

    List<comments> allComments(Integer postId);

    List<comments> myComments();

    void delete(Integer id);
}
