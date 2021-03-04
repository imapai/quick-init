package top.amfun.quickinit.controller;

import cn.hutool.core.collection.CollUtil;
import top.amfun.quickinit.domain.RestResponse;
import top.amfun.quickinit.dto.LoginForm;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.entity.User;
import top.amfun.quickinit.service.RoleService;
import top.amfun.quickinit.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public RestResponse<User> register(@RequestBody User user) {
        User userRegister = userService.register(user);
        if (userRegister == null) {
            return RestResponse.failed(userRegister);
        }
        return RestResponse.success(userRegister);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public RestResponse<String> login(@RequestBody LoginForm loginForm) {
        String token = userService.login(loginForm.getUsername(), loginForm.getPassword());
        if (token == null) {
            return RestResponse.failed("用户名或密码错误");
        }
        return RestResponse.success(token);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public RestResponse<Map<String, Object>> getAdminInfo(Principal principal) {
        if(principal==null){
            return RestResponse.unauthorized(null);
        }
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", user.getUsername());
        // 动态菜单
        data.put("menus", roleService.getMenuList(user.getUserId()));
        data.put("avatar", user.getAvatar());
        List<Role> roleList = userService.getRoleList(user.getUserId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(Role::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return RestResponse.success(data);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse logout() {
        return RestResponse.success();
    }
}

