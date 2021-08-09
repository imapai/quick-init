package top.amfun.quickinit.mapper;

import org.apache.ibatis.annotations.Param;
import top.amfun.quickinit.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuListByUserId(@Param("userId") Long userId);
}
