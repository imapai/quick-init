package top.amfun.quickinit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.amfun.quickinit.common.RestResponse;
import top.amfun.quickinit.entity.Menu;
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
    RestResponse<Menu> getMenu(@RequestBody Menu menu) {
        return RestResponse.success(menuService.createMenu(menu));
    }

    @ApiOperation("全部的菜单")
    @GetMapping
    RestResponse<List<Menu>> menuList() {
        return RestResponse.success(menuService.allMenuList());
    }


}

