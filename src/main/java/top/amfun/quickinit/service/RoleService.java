package top.amfun.quickinit.service;

import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RoleService extends IService<Role> {

    List<Menu> getMenuList(Long userId);

    void create(Role role);

    void modify(Role role);
}
