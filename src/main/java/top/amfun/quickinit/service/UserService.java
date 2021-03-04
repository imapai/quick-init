package top.amfun.quickinit.service;

import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService extends IService<User> {

    User getUserByUsername(String username);

    User register(User user);

    String login(String username, String password);

    UserDetails loadUserByUsername(String username);

    List<Role> getRoleList(Long userId);
}
