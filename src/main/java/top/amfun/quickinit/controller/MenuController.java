package top.amfun.quickinit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.amfun.quickinit.common.CurrentUser;
import top.amfun.quickinit.common.PageResponse;
import top.amfun.quickinit.common.RestResponse;
import top.amfun.quickinit.common.SystemSecurityContext;
import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.pojo.qo.MenuPageQuery;
import top.amfun.quickinit.service.MenuService;

import java.util.List;

@Api(tags = "菜单")
@RestController
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ApiOperation("新建菜单")
    @PostMapping
    RestResponse<Menu> createMenu(@RequestBody Menu menu) {
        return RestResponse.success(menuService.createMenu(menu));
    }

    @ApiOperation("获取菜单详情")
    @GetMapping("/{menuId}")
    RestResponse<Menu> getMenu(@PathVariable("menuId") Long menuId) {
        return RestResponse.success(menuService.getMenuById(menuId));
    }

    @ApiOperation("全部的菜单")
    @GetMapping
    RestResponse<List<Menu>> menuList() {
        CurrentUser currentUser = SystemSecurityContext.getSubject();
        List<Long> roleIdes = currentUser.getRoleIdes();
        return RestResponse.success(menuService.allMenuList(roleIdes));
    }

    @ApiOperation("菜单分页查询")
    @PostMapping("/p")
    RestResponse<PageResponse<Menu>> menuPageSelect(@RequestBody MenuPageQuery menuPageQuery) {
        return RestResponse.success(menuService.pageSelect(menuPageQuery));
    }


}

