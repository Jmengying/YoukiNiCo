package top.yjx1125.anime.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class User {
    @NotNull
    private Integer id;
    private String username;
    @JsonIgnore//转换成JSON时,忽略其值
    private String password;
    @NotEmpty
    @Pattern(regexp = "^\\S{4,10}$")
    private String nickname;
    //@Auth
    private String auth;
    @NotEmpty
    @Email
    private String email;
    private String userPic;

}
