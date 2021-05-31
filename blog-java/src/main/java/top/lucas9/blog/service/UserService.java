package top.lucas9.blog.service;

import top.lucas9.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lucas9.blog.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lucas9
 * @since 2021-05-27
 */
public interface UserService extends IService<User> {
    public UserInfo login(String username, String password, HttpServletRequest request, HttpServletResponse response);

}
