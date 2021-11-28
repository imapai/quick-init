package top.amfun.quickinit.common;

import lombok.Data;
import top.amfun.quickinit.entity.Role;
import top.amfun.quickinit.entity.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author codancer
 * @date 2021/11/28 16:38
 */
@Data
public class CurrentUser {
    private User user;
    private List<Role> roles;

    public String getUsername() {
        return this.user.getUsername();
    }

    public List<Long> getRoleIdes() {
        if (this.roles != null && this.roles.size() > 0) {
            return this.roles.stream().map(e -> e.getRoleId()).collect(Collectors.toList());
        }
        return null;
    }
}
