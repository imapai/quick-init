package top.amfun.quickinit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.amfun.quickinit.common.CurrentUser;
import top.amfun.quickinit.common.RestResponse;
import top.amfun.quickinit.common.SystemSecurityContext;
import top.amfun.quickinit.entity.User;
import top.amfun.quickinit.pojo.dto.LoginForm;
import top.amfun.quickinit.service.MenuService;
import top.amfun.quickinit.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private MenuService menuService;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public RestResponse<User> register(@RequestBody User user) {
        return RestResponse.success(userService.register(user));
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public RestResponse<String> login(@RequestBody LoginForm loginForm) {
        String token = userService.login(loginForm.getUsername(), loginForm.getPassword());
        if (token == null) {
            return RestResponse.failed("用户名或密码错误");
        }
        return RestResponse.success("Bearer "+ token);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public RestResponse<Map<String, Object>> getAdminInfo() {
        CurrentUser subject = SystemSecurityContext.getSubject();
        User user = subject.getUser();
        Map<String, Object> data = new HashMap<>();
        data.put("username", user.getUsername());
        data.put("menus", menuService.getMenuList(user.getUserId()));
        data.put("avatar", user.getAvatar());
        data.put("roles", subject.getRoles());
        return RestResponse.success(data);
    }
}

