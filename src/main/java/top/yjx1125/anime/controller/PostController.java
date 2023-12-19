package top.yjx1125.anime.controller;

import com.auth0.jwt.interfaces.Claim;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yjx1125.anime.pojo.Result;
import top.yjx1125.anime.pojo.posts;
import top.yjx1125.anime.service.CommentService;
import top.yjx1125.anime.service.PostService;
import top.yjx1125.anime.utils.JwtUtil;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("/addPost")
    public Result add(@RequestBody @Validated posts post){
        postService.add(post);
        return Result.success();
    }

    @GetMapping("/myPost")
    public Result<List<posts>> myList(){
        List<posts> p = postService.myList();
        return Result.success(p);
    }

}
