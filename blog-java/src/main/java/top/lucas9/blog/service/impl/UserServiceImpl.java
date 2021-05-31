package top.lucas9.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.Assert;
import top.lucas9.blog.entity.User;
import top.lucas9.blog.entity.UserInfo;
import top.lucas9.blog.mapper.UserMapper;
import top.lucas9.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lucas9.blog.utils.EncryptUtil;
import top.lucas9.blog.utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lucas9
 * @since 2021-05-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    public UserInfo login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = getOne(new QueryWrapper<User>().eq("username", username));
        Assert.notNull(user, "用户名或密码错误");
        if(!user.getPassword().equals(EncryptUtil.encryptPassword(password, user.getSalt()))) {
            throw new IllegalArgumentException("用户名或密码错误");
        }
        String jwt = JwtUtil.createToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setAvatar(user.getAvatar());
        userInfo.setUsername(user.getUsername());
        userInfo.setEmail(user.getEmail());
        return userInfo;
    }
}
