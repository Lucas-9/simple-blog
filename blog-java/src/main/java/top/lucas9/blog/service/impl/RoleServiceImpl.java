package top.lucas9.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.lucas9.blog.entity.Role;
import top.lucas9.blog.mapper.RoleMapper;
import top.lucas9.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lucas9
 * @since 2021-05-27
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public List<String> getRoles(Long userId) {
        return roleMapper.getRoles(userId);
    }

}
