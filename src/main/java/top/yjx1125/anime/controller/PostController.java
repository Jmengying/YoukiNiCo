package top.yjx1125.anime.controller;

import com.auth0.jwt.interfaces.Claim;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
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
    public Result add(@RequestBody @Validated(posts.Add.class) posts post){
        postService.add(post);
        return Result.success();
    }

    @GetMapping("/myPost")
    public Result<List<posts>> myList(){
        List<posts> p = postService.myList();
        return Result.success(p);
    }

    @GetMapping("/allPost")
    public Result<List<posts>> allList(){
        List<posts> p = postService.allList();
        return Result.success(p);
    }

    @GetMapping("/detail")
    public Result<posts> postDetails(Integer id){
        posts p = postService.findById(id);
        return Result.success(p);

    }

    @PutMapping("/updatePost")
    public Result updatePost(@RequestBody @Validated(posts.Update.class)  posts post){
        postService.updatePost(post);
        return Result.success();
    }

    @DeleteMapping("/deletePost")
    public Result deletePost(Integer id){
        postService.delete(id);
        return Result.success();
    }
}
