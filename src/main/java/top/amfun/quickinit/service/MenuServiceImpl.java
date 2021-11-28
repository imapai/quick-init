package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.mapper.MenuMapper;
import top.amfun.quickinit.mapper.RoleMenuMapper;

import java.util.List;

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
    public List<Menu> allMenuList() {
        return menuMapper.selectList(null);
    }
}
