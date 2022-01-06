package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.entity.RoleMenu;
import top.amfun.quickinit.mapper.MenuMapper;
import top.amfun.quickinit.mapper.RoleMenuMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Menu> getMenuList(Long userId) {
        return menuMapper.getMenuListByUserId(userId);
    }

    @Override
    public Menu createMenu(Menu menu) {
        menu.setMenuId(IdWorker.getId());
        return menu;
    }

    @Override
    public List<Menu> allMenuList(List<Long> roleIdes) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(RoleMenu::getRoleId, roleIdes);
        List<RoleMenu> roleMenus = roleMenuMapper.selectList(queryWrapper);
        List<Long> menuIds = roleMenus.stream().map(e -> e.getMenuId()).distinct().collect(Collectors.toList());
        LambdaQueryWrapper<Menu> menuWrapper = new LambdaQueryWrapper<>();
        menuWrapper.in(Menu::getMenuId, menuIds);
        return menuMapper.selectList(menuWrapper);
    }

    @Override
    public Menu getMenu(Long menuId) {
        return menuMapper.selectById(menuId);
    }
}
