package top.amfun.quickinit.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.amfun.quickinit.config.ExceptionAsserts;
import top.amfun.quickinit.mapper.RoleMapper;
import top.amfun.quickinit.mapper.UserMapper;
import top.amfun.quickinit.common.UserDetailsImpl;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.entity.User;
import top.amfun.quickinit.utli.JwtTokenUtil;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User getUserByUsername(String username) {
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.eq(User::getUsername, username);
        List<User> users = baseMapper.selectList(lambda);
        if (ObjectUtil.isNotNull(users) && !users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User register(User user) {
        // 查询用户名相同
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.eq(User::getUsername, user.getUsername());
        List<User> users = baseMapper.selectList(lambda);
        if (users.isEmpty()) {
            user.setUserId(IdWorker.getId());
            baseMapper.insert(user);
            return user;
        }
        return null;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!password.equals(userDetails.getPassword())){
                ExceptionAsserts.fail("用户名或者密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (Exception e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        User user = getUserByUsername(username);
        if (user != null) {
            //List<UmsResource> resourceList = getResourceList(admin.getId());
            List<Role> roleList = getRoleList(user.getUserId());
            return new UserDetailsImpl(user, roleList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public List<Role> getRoleList(Long userId) {
        return roleMapper.selectRolesByUserId(userId);
    }
}
