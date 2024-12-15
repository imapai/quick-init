package top.amfun.quickinit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.amfun.quickinit.entity.Menu;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceImplTest {
    @Autowired
    private MenuService menuService;

    @Test
    void getMenuList() {
        List<Menu> menuList = menuService.getMenuList(1L);
        assertNotNull(menuList);
    }
}