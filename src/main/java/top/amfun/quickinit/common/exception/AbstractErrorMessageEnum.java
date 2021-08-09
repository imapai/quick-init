package top.amfun.quickinit.common.exception;

public interface AbstractErrorMessageEnum {
    String getErrorMessage();
    Integer getCode();

    default String getName() {
        if (this instanceof Enum) {
            Enum thisEnum = (Enum) this;
            return thisEnum.name();
        } else {
            throw new IllegalArgumentException("illegal argument " + this);
        }
    }

    default BusinessException businessException() {
        return new BusinessException(this.getCode(), this.getErrorMessage());
    }

    default BusinessException businessException(String msg) {
        return new BusinessException(this.getCode(), msg);
    }

    /**
     * 未知业务异常编码
     */
    int CODE_UNKNOWN_EXCEPTION = -2;

    /**
     * 未知异常编码，不建议直接使用
     */
    String MSG_UNKNOWN_EXCEPTION = "未知错误";

    /**
     * 系统异常编码
     */
    int CODE_SYSTEM_EXCEPTION = -3;

    default BusinessException unknownException() {
        return new BusinessException(CODE_UNKNOWN_EXCEPTION, MSG_UNKNOWN_EXCEPTION);
    }

    default SystemException systemException() {
        return new SystemException(CODE_SYSTEM_EXCEPTION, this.getErrorMessage());
    }

    default SystemException systemException(String msg) {
        return new SystemException(CODE_SYSTEM_EXCEPTION, String.format("%s: %s",this.getErrorMessage(),msg));
    }
}

