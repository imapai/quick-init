package top.amfun.quickinit.pojo.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.amfun.quickinit.common.PageRequest;

/**
 * @author zhaoxg
 * @date 2022/1/4 17:22
 */
@Data
public class MenuPageQuery extends PageRequest {
    @ApiModelProperty(value = "标题")
    private String title;
}
