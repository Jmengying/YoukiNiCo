package top.yjx1125.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yjx1125.anime.pojo.Result;
import top.yjx1125.anime.pojo.comments;
import top.yjx1125.anime.service.CommentService;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public Result add(@RequestBody @Validated comments comment){
        commentService.add(comment);
        return Result.success();
    }

    @GetMapping("/allComments")
    public Result<List<comments>> allComments(Integer postId){
        List<comments> c = commentService.allComments(postId);
        return Result.success(c);
    }

    @GetMapping("/myComments")
    public Result<List<comments>> myComments(){
        List<comments> c = commentService.myComments();
        return Result.success(c);
    }

    @DeleteMapping("/deleteComment")
    public Result deleteComment(Integer id){
        commentService.delete(id);
        return Result.success();
    }
}
