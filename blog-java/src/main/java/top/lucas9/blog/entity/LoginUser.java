package top.lucas9.blog.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class LoginUser implements Serializable {
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "用户密码不能为空")
    private String password;

    public LoginUser() {
    }

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
