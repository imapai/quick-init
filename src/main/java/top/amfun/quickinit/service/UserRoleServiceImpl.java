package top.amfun.quickinit.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.amfun.quickinit.mapper.UserRoleMapper;
import top.amfun.quickinit.entity.UserRole;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
