package top.yjx1125.anime.pojo;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
@Data
public class posts {
    @NotNull(groups = Update.class)
    private Integer id;
    @NotEmpty(groups = {Add.class,Update.class})
    @Pattern(regexp = "^//S{1,15}$")
    private String title;
    @NotEmpty(groups = {Add.class,Update.class})
    private String body;
    private LocalDateTime createdAt;
    @NotNull
    private Integer userId;
    @URL
    private String postImg;

    public interface Add{

    }

    public interface Update{

    }
}
