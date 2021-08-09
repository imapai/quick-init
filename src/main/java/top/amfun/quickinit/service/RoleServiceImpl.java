package top.amfun.quickinit.service;

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
