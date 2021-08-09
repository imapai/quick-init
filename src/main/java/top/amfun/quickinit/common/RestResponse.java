package top.amfun.quickinit.common;

import top.amfun.quickinit.constant.ResultCodeEnum;

/**
 * 前后端交互实体类
 */
public class RestResponse<T> {

    private int code;

    private String message;

    private T data;

    public RestResponse(){}

    public RestResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> RestResponse<T> success() {
        return new RestResponse<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), null);
    }
    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }
    public static <T> RestResponse<T> success(T data, String message) {
        return new RestResponse<>(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }
    public static <T> RestResponse<T> failed(String message) {
        return new RestResponse<>(ResultCodeEnum.FAILED.getCode(), message, null);
    }
    public static <T> RestResponse<T> failed() {
        return new RestResponse<>(ResultCodeEnum.FAILED.getCode(), ResultCodeEnum.FAILED.getMessage(), null);
    }
    public static <T> RestResponse<T> failed(T data) {
        return new RestResponse<>(ResultCodeEnum.FAILED.getCode(), ResultCodeEnum.FAILED.getMessage(), data);
    }
    public static <T> RestResponse<T> failed(T data, String message) {
        return new RestResponse<>(ResultCodeEnum.FAILED.getCode(), message, data);
    }
    public static <T> RestResponse<T> fail(Integer code, String msg) {
        RestResponse<T> response = new RestResponse<T>();
        response.setCode(code);
        response.setMessage(msg);
        return response;
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> RestResponse<T> validateFailed(String message) {
        return new RestResponse<>(ResultCodeEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    public static <T> RestResponse<T> unauthorized(T data) {
        return new RestResponse<>(ResultCodeEnum.UNAUTHORIZED.getCode(), ResultCodeEnum.UNAUTHORIZED.getMessage(), data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
