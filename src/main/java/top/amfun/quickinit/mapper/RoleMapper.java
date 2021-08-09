package top.amfun.quickinit.mapper;

import top.amfun.quickinit.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectRolesByUserId(Long userId);
}
