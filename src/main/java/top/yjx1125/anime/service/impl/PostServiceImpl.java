package top.yjx1125.anime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yjx1125.anime.mapper.postMapper;
import top.yjx1125.anime.pojo.posts;
import top.yjx1125.anime.service.PostService;
import top.yjx1125.anime.utils.ThreadLocalUtil;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private postMapper postMapper;

    @Override
    public void add(posts post) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        post.setUserId(id);
        postMapper.add(post);
    }

    @Override
    public List<posts> myList() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        return postMapper.myList(id);

    }

    @Override
    public List<posts> allList() {
        return postMapper.allList();
    }

    @Override
    public posts findById(Integer id) {
        return postMapper.findById(id);
    }

    @Override
    public void updatePost(posts post) {
        postMapper.update(post);
    }

    @Override
    public void delete(Integer id) {
        postMapper.delete(id);
    }
}
