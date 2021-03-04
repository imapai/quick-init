package top.amfun.quickinit.service.impl;

import top.amfun.quickinit.entity.UserRole;
import top.amfun.quickinit.dao.UserRoleMapper;
import top.amfun.quickinit.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
