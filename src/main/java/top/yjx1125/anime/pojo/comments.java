package top.yjx1125.anime.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class comments {
    private Integer id;
    @NotEmpty
    private String body;
    private LocalDateTime createdAt;
    private Integer userId;
    private Integer postId;
}
