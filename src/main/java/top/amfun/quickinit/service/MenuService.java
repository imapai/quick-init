package top.amfun.quickinit.service;

import top.amfun.quickinit.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuList(Long userId);

    Menu createMenu(Menu menu);

    List<Menu> allMenuList(List<Long> roleIdes);

    Menu getMenu(Long menuId);
}
