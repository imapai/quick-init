package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.amfun.quickinit.common.PageResponse;
import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.pojo.qo.MenuPageQuery;

import java.util.List;

public interface MenuService extends IService<Menu> {
    List<Menu> getMenuList(Long userId);

    List<Menu> allMenuList(List<Long> roleIdes);

    PageResponse<Menu> pageSelect(MenuPageQuery menuPageQuery);
}
