package top.amfun.quickinit.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhaoxg
 * @date 2024/6/4 10:46
 */
@Data
public class RolePermissionsDTO {
    private Long roleId;
    private List<Long> permissionIds;
}
