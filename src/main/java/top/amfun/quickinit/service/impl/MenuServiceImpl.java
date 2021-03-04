package top.amfun.quickinit.service.impl;

import top.amfun.quickinit.entity.Menu;
import top.amfun.quickinit.dao.MenuMapper;
import top.amfun.quickinit.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
