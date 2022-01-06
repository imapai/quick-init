package top.amfun.quickinit.service;

import top.amfun.quickinit.common.PageResponse;
import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.pojo.qo.MenuPageQuery;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuList(Long userId);

    Menu createMenu(Menu menu);

    List<Menu> allMenuList();

    Menu getMenuById(Long menuId);

    PageResponse<Menu> pageSelect(MenuPageQuery menuPageQuery);
}
