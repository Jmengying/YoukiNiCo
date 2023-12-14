package top.yjx1125.anime.pojo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class comments {
    private Integer id;
    private String body;
    private LocalDateTime createdAt;
    private Integer userId;
    private Integer postId;
}
