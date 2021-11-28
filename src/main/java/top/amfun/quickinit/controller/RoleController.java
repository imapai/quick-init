package top.amfun.quickinit.controller;

import top.amfun.quickinit.common.PageResponse;
import top.amfun.quickinit.common.RestResponse;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "角色")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("添加角色")
    @PostMapping
    RestResponse<Role> create(@RequestBody Role role) {
        roleService.create(role);
        return RestResponse.success();
    }

    @ApiOperation("修改角色")
    @PutMapping
    RestResponse update(@RequestBody Role role) {
        roleService.modify(role);
        return RestResponse.success();
    }

    @ApiOperation("角色分页条件查询")
    @GetMapping(value = "/p")
    RestResponse<PageResponse<Role>> getRoleList() {
        return RestResponse.success();
    }

}

