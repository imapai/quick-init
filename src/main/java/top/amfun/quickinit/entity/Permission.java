package top.amfun.quickinit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhaoxg
 * @date 2024/6/3 17:25
 */
@TableName("permission")
@ApiModel(value="权限", description="权限表")
@Data
public class Permission {
    @ApiModelProperty("主键")
    @TableId(value = "permission_id", type = IdType.ASSIGN_ID)
    private Long permissionId;
    @ApiModelProperty("权限名称")
    private String name;
    @ApiModelProperty("权限标识")
    private String code;
}
