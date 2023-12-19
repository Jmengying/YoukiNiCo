package top.yjx1125.anime.pojo;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class posts {
    private Integer id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String body;
    private LocalDateTime createdAt;
    private Integer userId;
}
