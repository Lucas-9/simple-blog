package top.lucas9.blog.mapper;

import top.lucas9.blog.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lucas9
 * @since 2021-05-27
 */
public interface RoleMapper extends BaseMapper<Role> {
    public List<String> getRoles(Long userId);
}
