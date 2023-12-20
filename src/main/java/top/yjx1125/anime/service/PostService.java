package top.yjx1125.anime.service;

import top.yjx1125.anime.pojo.posts;

import java.util.List;

public interface PostService {
    void add(posts post);

    List<posts> myList();

    List<posts> allList();

    posts findById(Integer id);

    void updatePost(posts post);

    void delete(Integer id);
}
