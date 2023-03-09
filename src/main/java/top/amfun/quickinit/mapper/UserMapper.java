package top.amfun.quickinit.mapper;

import org.springframework.stereotype.Repository;
import top.amfun.quickinit.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
