package top.amfun.quickinit.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.amfun.quickinit.common.exception.AbstractErrorMessageEnum;

@Getter
@AllArgsConstructor
public enum SystemErrorEnum implements AbstractErrorMessageEnum {
    ;

    private Integer code;
    private String errorMessage;
}
