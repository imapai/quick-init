package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.amfun.quickinit.entity.Permission;
import top.amfun.quickinit.entity.RolePermission;
import top.amfun.quickinit.mapper.PermissionMapper;

import java.util.Collections;
import java.util.List;

/**
 * @author zhaoxg
 * @date 2024/6/4 10:19
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}
