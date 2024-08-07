package top.amfun.quickinit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.amfun.quickinit.common.PageResponse;
import top.amfun.quickinit.common.RestResponse;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.pojo.dto.RolePermissionsDTO;
import top.amfun.quickinit.pojo.qo.RolePageQuery;
import top.amfun.quickinit.service.RoleService;

import javax.annotation.Resource;

@Api(tags = "角色")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @ApiOperation("添加角色")
    @PostMapping
    RestResponse<Role> create(@RequestBody Role role) {
        return RestResponse.success(roleService.create(role));
    }

    @ApiOperation("根据ID获取角色信息")
    @GetMapping("/{roleId}")
    RestResponse<Role> getRoleById(@PathVariable("roleId") Long roleId) {
        return RestResponse.success(roleService.getRoleById(roleId));
    }

    @ApiOperation("修改角色")
    @PutMapping
    RestResponse<Role> update(@RequestBody Role role) {
        return RestResponse.success(roleService.modify(role));
    }

    @ApiOperation("角色分页条件查询")
    @PostMapping("/p")
    RestResponse<PageResponse<Role>> getRoleList(@RequestBody RolePageQuery rolePageQuery) {
        return RestResponse.success(roleService.pageSelect(rolePageQuery));
    }

    @ApiOperation("角色绑定权限")
    @PostMapping("/permission/bind")
    RestResponse<Integer> roleBindPermission(@RequestBody RolePermissionsDTO rolePermissionsDTO) {
        return RestResponse.success(roleService.bindPermission(rolePermissionsDTO));
    }

}

