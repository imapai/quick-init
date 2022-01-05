package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.amfun.quickinit.common.PageResponse;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.pojo.qo.RolePageQuery;

public interface RoleService extends IService<Role> {

    Role create(Role role);

    Role modify(Role role);

    Role getRoleById(Long roleId);

    PageResponse<Role> pageSelect(RolePageQuery rolePageQuery);
}
