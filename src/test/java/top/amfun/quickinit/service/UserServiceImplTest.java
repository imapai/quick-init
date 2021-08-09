package top.amfun.quickinit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void getRoleList() {
        List<Role> roleList = userService.getRoleList(1L);
        assertNotNull(roleList);
    }

    @Test
    void test() {
        User user = userService.getById(1L);
        assertNotNull(user);
    }

}