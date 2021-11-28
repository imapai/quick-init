package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.amfun.quickinit.entity.Role;

public interface RoleService extends IService<Role> {

    Role create(Role role);

    Role modify(Role role);

    Role getRoleById(Long roleId);
}
