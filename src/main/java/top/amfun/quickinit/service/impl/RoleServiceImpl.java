package top.amfun.quickinit.service.impl;

import top.amfun.quickinit.dao.MenuMapper;
import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.dao.RoleMapper;
import top.amfun.quickinit.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuList(Long userId) {
        return menuMapper.getMenuListByUserId(userId);
    }

    @Override
    public void create(Role role) {
        baseMapper.insert(role);
    }

    @Override
    public void modify(Role role) {

    }
}
