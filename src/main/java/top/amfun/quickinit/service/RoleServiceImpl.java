package top.amfun.quickinit.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.amfun.quickinit.common.PageResponse;
import top.amfun.quickinit.entity.RolePermission;
import top.amfun.quickinit.mapper.RoleMapper;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.mapper.RolePermissionMapper;
import top.amfun.quickinit.pojo.dto.RolePermissionsDTO;
import top.amfun.quickinit.pojo.qo.RolePageQuery;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;

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

    @Override
    public PageResponse<Role> pageSelect(RolePageQuery query) {
        Page<Role> page = new Page<>(query.getPage(), query.getPageSize());
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotEmpty(query.getName())) {
            queryWrapper.like(Role::getName, query.getName());
        }
        queryWrapper.orderByDesc(Role::getCreateTime);
        return PageResponse.restPage(baseMapper.selectPage(page, queryWrapper));
    }

    @Override
    public Integer bindPermission(RolePermissionsDTO dto) {
        AtomicInteger count = new AtomicInteger(0);
        dto.getPermissionIds().forEach(e -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRolePermissionId(IdWorker.getId());
            rolePermission.setRoleId(dto.getRoleId());
            rolePermission.setPermissionId(e);
            int i = rolePermissionMapper.insert(rolePermission);
            count.addAndGet(i);
        });
        return count.get();
    }
}
