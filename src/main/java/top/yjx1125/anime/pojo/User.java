package top.yjx1125.anime.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String auth;
    private String email;
    private String userPic;

}
