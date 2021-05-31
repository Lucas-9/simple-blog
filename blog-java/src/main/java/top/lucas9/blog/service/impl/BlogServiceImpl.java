package top.lucas9.blog.service.impl;

import top.lucas9.blog.entity.Blog;
import top.lucas9.blog.mapper.BlogMapper;
import top.lucas9.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lucas9
 * @since 2021-05-27
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
