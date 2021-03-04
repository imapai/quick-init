package top.amfun.quickinit.dao;

import top.amfun.quickinit.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuListByUserId(Long userId);
}
