package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.amfun.quickinit.entity.Permission;
import top.amfun.quickinit.entity.RolePermission;

import java.util.List;

/**
 * @author zhaoxg
 * @date 2024/6/4 10:24
 */
public interface RolePermissionService extends IService<RolePermission> {
    List<Permission> allPermissions(List<Long> roleIds);
}
