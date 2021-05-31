package top.lucas9.blog.service;

import top.lucas9.blog.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lucas9
 * @since 2021-05-27
 */
public interface RoleService extends IService<Role> {
    public List<String> getRoles(Long userId);
}
