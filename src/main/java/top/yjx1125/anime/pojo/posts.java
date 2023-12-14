package top.yjx1125.anime.pojo;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class posts {
    private Integer id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private Integer userId;
}
