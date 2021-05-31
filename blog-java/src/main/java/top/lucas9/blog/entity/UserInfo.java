package top.lucas9.blog.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private Long id;
    private String username;
    private String avatar;
    private String email;

    public UserInfo() {
    }

    public UserInfo(Long id, String username, String avatar, String email) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
