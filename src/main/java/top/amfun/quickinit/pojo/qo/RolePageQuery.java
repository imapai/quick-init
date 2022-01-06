package top.amfun.quickinit.pojo.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.amfun.quickinit.common.PageRequest;

/**
 * @author zhaoxg
 * @date 2022/1/4 16:59
 */
@Data
public class RolePageQuery extends PageRequest {
    @ApiModelProperty(value = "角色名称")
    private String name;
}
