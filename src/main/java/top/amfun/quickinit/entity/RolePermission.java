package top.amfun.quickinit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhaoxg
 * @date 2024/6/3 17:29
 */
@TableName("role_permission")
@ApiModel(value="角色权限关联", description="角色权限关联表")
@Data
public class RolePermission {
    @TableId(value = "role_permission_id", type = IdType.ASSIGN_ID)
    private Long rolePermissionId;
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    @ApiModelProperty(value = "权限ID")
    private Long permissionId;
}
