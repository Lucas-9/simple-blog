package top.lucas9.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import top.lucas9.blog.entity.Blog;
import top.lucas9.blog.entity.ResultEntity;
import top.lucas9.blog.service.BlogService;

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
@RequestMapping("/blog")
@Api(tags = "博客模块")
public class BlogController {
    @Autowired
    BlogService blogService;

    @ApiOperation("根据当前页数分页查询博客列表")
    @GetMapping("/blogs")
    public ResultEntity<IPage> blogs(@RequestParam("currentPage") Integer currentPage) {
        if(null == currentPage || currentPage < 1) {
            currentPage = 1;
        }
        IPage pageData = blogService.page(
                new Page(currentPage, 5),
                new QueryWrapper<Blog>().orderByDesc("created"));
        return ResultEntity.success(pageData);
    }

    @ApiOperation("根据博客id展示博客详情")
    @GetMapping("/detail")
    public ResultEntity<Blog> detail(@RequestParam("blogId") Long blogId) {
        Assert.notNull(blogId, "博客id不能为空");
        Blog blog = blogService.getById(blogId);
        Assert.notNull(blog, "该博客已删除！");
        return ResultEntity.success(blog);
    }

    @ApiOperation("编辑或保存博客")
    @RequiresRoles("admin")
    @PostMapping("/edit")
    public ResultEntity edit(@Valid @RequestBody Blog blog) {
        blogService.saveOrUpdate(blog);
        return ResultEntity.success();
    }

    @ApiOperation("根据博客id删除博客")
    @RequiresRoles("admin")
    @GetMapping("/delete")
    public ResultEntity delete(@RequestParam(value = "blogId") Long blogId) {
        Assert.notNull(blogId, "博客id不能为空");
        boolean flag = blogService.removeById(blogId);
        if (flag) {
            return ResultEntity.success();
        } else {
            return ResultEntity.failed();
        }
    }
}
