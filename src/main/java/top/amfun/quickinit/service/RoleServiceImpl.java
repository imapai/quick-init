package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.amfun.quickinit.mapper.MenuMapper;
import top.amfun.quickinit.mapper.RoleMapper;
import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.entity.Role;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public Role create(Role role) {
        role.setRoleId(IdWorker.getId());
        baseMapper.insert(role);
        return getRoleById(role.getRoleId());
    }

    @Override
    public Role modify(Role role) {
        baseMapper.updateById(role);
        return getRoleById(role.getRoleId());
    }

    @Override
    public Role getRoleById(Long roleId) {
        return baseMapper.selectById(roleId);
    }
}
