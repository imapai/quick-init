package top.amfun.quickinit.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SystemException extends RuntimeException {
    private Integer code;
    private String message;

    public SystemException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public SystemException(String message) {
        super(message);
        this.message = message;
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    protected SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message;
    }
}
