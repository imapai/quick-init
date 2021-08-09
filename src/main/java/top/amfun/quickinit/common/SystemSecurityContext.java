package top.amfun.quickinit.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import top.amfun.quickinit.common.exception.CommonErrorMessageEnum;
import top.amfun.quickinit.entity.User;

@Slf4j
public class SystemSecurityContext {
    public static User getSubject() {
        if(SecurityContextHolder.getContext() == null
                || SecurityContextHolder.getContext().getAuthentication() == null
                || SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null) {
            log.warn("SecurityContextHolder未获取到任何东西");
            throw CommonErrorMessageEnum.NO_LOGIN.businessException();
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof  User){
            return (User) principal;
        } else {
            log.warn("SecurityContextHolder数据转换失败");
            throw CommonErrorMessageEnum.NO_LOGIN.businessException();
        }
    }
}
