package top.lucas9.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import top.lucas9.blog.entity.LoginUser;
import top.lucas9.blog.entity.ResultEntity;
import top.lucas9.blog.entity.UserInfo;
import top.lucas9.blog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lucas9
 * @since 2021-05-27
 */
@RestController
@Api(tags = "用户模块")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResultEntity<UserInfo> login(
            @Valid @RequestBody LoginUser loginUser,
            HttpServletRequest request,
            HttpServletResponse response) {
        UserInfo userInfo = userService.login(loginUser.getUsername(), loginUser.getPassword(), request, response);
        Assert.notNull(userInfo, "用户名或密码错误");
        return ResultEntity.success(userInfo);
    }

    @ApiOperation("用户退出登录")
    @RequiresAuthentication
    @PostMapping("/logout")
    public ResultEntity logout() {
        SecurityUtils.getSubject().logout();
        return ResultEntity.success();
    }
}
